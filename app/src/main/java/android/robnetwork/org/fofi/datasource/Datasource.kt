package android.robnetwork.org.fofi.datasource

import android.robnetwork.org.fofi.model.FilmType
import android.robnetwork.org.fofi.model.Iso
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Observable
import io.reactivex.Single

object Datasource {
    fun <T : Any> getAll(klass: Class<T>): Single<List<T>> = Observable.create<T> { emitter ->
        klass.newInstance().collection().get().addOnSuccessListener { querySnapshot ->
            querySnapshot.documents.forEach { docSnapshot ->
                docSnapshot.toModel(klass)?.let { emitter.onNext(it) }
            }
        }.addOnFailureListener { emitter.onError(it) }
    }.toList()

    fun <T : Any> add(pojo: T): Single<T> = Single.create<T> { singleEmitter ->
        pojo.collection().addModel(pojo)
            .addOnSuccessListener { singleEmitter.onSuccess(pojo) }
            .addOnFailureListener { singleEmitter.onError(it) }
    }

    private fun <T : Any> T.collection() = FirebaseFirestore.getInstance().collection(javaClass.simpleName)

    private fun <T : Any> CollectionReference.addModel(model: T) = add(
        when (model) {
            is Iso -> model.toMap()
            is FilmType -> model.toMap()
            else -> model
        }
    )

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    private fun <T : Any> DocumentSnapshot.toModel(klass: Class<T>): T? = (when (klass.newInstance()) {
        is Iso -> Iso.toModel(this)
        is FilmType -> FilmType.toModel(this)
        else -> toObject(klass)
    } as? T)
}
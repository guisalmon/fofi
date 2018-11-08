package android.robnetwork.org.fofi.datasource

import android.robnetwork.org.fofi.model.*
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Single

object Datasource {

    fun addFilm(film: Film): Single<Film> = add(film, Film.COLLECTION)

    fun addRoll(roll: Roll): Single<Roll> = add(roll, Roll.COLLECTION)

    fun addTag(tag: Tag): Single<Tag> = add(tag, Tag.COLLECTION)

    fun addIso(iso: Iso): Single<Iso> = Single.create<Iso> { singleEmitter ->
        FirebaseFirestore.getInstance().collection(Iso.COLLECTION).add(iso.toMap())
            .addOnSuccessListener { singleEmitter.onSuccess(iso) }
            .addOnFailureListener { singleEmitter.onError(it) }
    }

    fun addFilmType(filmType: FilmType): Single<FilmType> = Single.create<FilmType> { singleEmitter ->
        FirebaseFirestore.getInstance().collection(FilmType.COLLECTION).add(filmType.toMap())
            .addOnSuccessListener { singleEmitter.onSuccess(filmType) }
            .addOnFailureListener { singleEmitter.onError(it) }
    }

    private fun <T : Any> add(pojo: T, collection: String) = Single.create<T> { singleEmitter ->
        FirebaseFirestore.getInstance().collection(collection).add(pojo)
            .addOnSuccessListener { singleEmitter.onSuccess(pojo) }
            .addOnFailureListener { singleEmitter.onError(it) }
    }
}
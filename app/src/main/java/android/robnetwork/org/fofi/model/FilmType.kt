package android.robnetwork.org.fofi.model

import com.google.firebase.firestore.DocumentSnapshot

enum class FilmType {
    BLACK_N_WHITE,
    COLOR_NEGATIVE,
    COLOR_POSITIVE,
    ANY;

    override fun toString() = name

    fun toMap() = mapOf(Pair("filmType", name))

    companion object {
        fun toModel(document: DocumentSnapshot) = (document.get("filmType") as? String)?.let { name ->
            values().firstOrNull { it.name == name} ?: ANY
        }
    }
}
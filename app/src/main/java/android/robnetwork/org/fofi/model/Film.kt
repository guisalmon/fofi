package android.robnetwork.org.fofi.model

import com.google.firebase.firestore.DocumentReference

data class Film(
    val brand: String = "",
    val name: String = "",
    val nominalIso: DocumentReference = Do,
    val type: FilmType = FilmType.ANY,
    val id: String = "$brand$name${nominalIso.value}"
)
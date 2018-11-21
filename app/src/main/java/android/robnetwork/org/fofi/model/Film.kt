package android.robnetwork.org.fofi.model

import android.robnetwork.org.fofi.datasource.Datasource.getReference
import com.google.firebase.firestore.DocumentReference

data class Film(
    val brand: String = "",
    val name: String = "",
    val nominalIsoPath: String = "",
    val typePath: String = "",
    val id: String = "$brand$name$nominalIsoPath"
) {
    val nominalIso: DocumentReference = Iso.getReference(nominalIsoPath)
    val type: DocumentReference = FilmType.getReference(typePath)
}
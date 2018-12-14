package android.robnetwork.org.fofi.model

import android.robnetwork.org.fofi.datasource.Datasource
import android.robnetwork.org.fofi.datasource.Datasource.getReference
import com.google.firebase.firestore.DocumentReference

data class Film(
    val brand: String = "",
    val name: String = "",
    val nominalIsoPath: String = Datasource.getReferencePath(Iso.ISO_ANY) ?: "",
    val typePath: String = Datasource.getReferencePath(FilmType.ANY) ?: "",
    val id: String = "$brand$name$nominalIsoPath"
) {
    val nominalIso: DocumentReference = Iso.getReference(nominalIsoPath)
    val type: DocumentReference = FilmType.getReference(typePath)

    override fun toString() = "$brand $name"
}
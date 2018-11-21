package android.robnetwork.org.fofi.model

import android.robnetwork.org.fofi.datasource.Datasource.getReference
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import java.util.*

data class Roll(
    val isoPath: String = "",
    val filmPath: String = "",
    val startDate: Timestamp = Timestamp(Date()),
    val endDate: Timestamp = Timestamp(Date()),
    val tags: List<String> = listOf(),
    val driveLocation: String = "",
    val lastAccessDate: Timestamp = Timestamp(Date())
) {
    val iso: DocumentReference = Iso.getReference(isoPath)
    val film: DocumentReference = Film().getReference(filmPath)
}
package android.robnetwork.org.fofi.model

import com.google.firebase.Timestamp
import java.util.*

data class Roll(
    val isoValue: Iso = Iso.ISO_ANY,
    val film: Film = Film(),
    val startDate: Timestamp = Timestamp(Date()),
    val endDate: Timestamp = Timestamp(Date()),
    val tags: List<Tag> = listOf(),
    val driveLocation: String = "",
    val lastAccessDate: Timestamp = Timestamp(Date()),
    val codeName: String = film.id + driveLocation
) {
    companion object {
        const val COLLECTION = "Rolls"
    }
}
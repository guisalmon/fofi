package android.robnetwork.org.fofi.model

import com.google.firebase.Timestamp
import java.util.*

data class Roll(
    val codeName: String = "",
    val filmType: FilmType = FilmType.ANY,
    val isoValue: Iso = Iso.ISO_ANY,
    val film: Film = Film(),
    val startDate: Timestamp = Timestamp(Date()),
    val endDate: Timestamp = Timestamp(Date()),
    val tags: List<Tag> = listOf(),
    val driveLocation: String = "",
    val lastAccessDate: Timestamp = Timestamp(Date())
) {
    companion object {
        const val COLLECTION = "Rolls"
    }
}
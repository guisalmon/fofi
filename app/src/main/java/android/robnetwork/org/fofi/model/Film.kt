package android.robnetwork.org.fofi.model

data class Film(
    val brand: String = "",
    val name: String = "",
    val nominalIso: Iso = Iso.ISO_ANY,
    val type: FilmType = FilmType.ANY,
    val id: String = "$brand$name${nominalIso.value}"
) {
    companion object {
        const val COLLECTION = "Films"
    }
}
package android.robnetwork.org.fofi.model

enum class FilmType {
    BLACK_N_WHITE,
    COLOR_NEGATIVE,
    COLOR_POSITIVE,
    ANY;

    companion object {
        const val COLLECTION = "FilmTypes"
    }
}
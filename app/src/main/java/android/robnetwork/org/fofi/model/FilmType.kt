package android.robnetwork.org.fofi.model

enum class FilmType {
    BLACK_N_WHITE,
    COLOR_NEGATIVE,
    COLOR_POSITIVE,
    ANY;

    override fun toString() = name

    fun toMap() = mapOf(Pair("filmType", name))

    companion object {
        const val COLLECTION = "FilmTypes"
    }
}
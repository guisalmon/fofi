package android.robnetwork.org.fofi.model

enum class Iso(val value: Int = 0) {
    ISO_ANY(0),
    ISO_100(100),
    ISO_125(125),
    ISO_200(200),
    ISO_400(400),
    ISO_800(800),
    ISO_1600(1600),
    ISO_3200(3200),
    ISO_6400(6400),
    ISO_12800(12800), ;

    override fun toString() = "${this.value} iso"

    fun toMap() = mapOf(Pair("iso", value))

    companion object {
        const val COLLECTION = "Isos"

        fun intToIso(value: Int) = values().firstOrNull { it.value == value } ?: ISO_ANY
    }
}
package cz.krajcovic.apduscripts.data

/**
 * Odpověď APDU
 */
data class ApduResponse(
    // Data odpovědi
    val nr: ByteArray,

    // Status provedení příkazu, např. 90 00 (hexadecimálně) představuje úspěch
    val SW1: Byte,
    val SW2: Byte) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ApduResponse

        if (!nr.contentEquals(other.nr)) return false
        if (SW1 != other.SW1) return false
        if (SW2 != other.SW2) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nr.contentHashCode()
        result = 31 * result + SW1
        result = 31 * result + SW2
        return result
    }
}

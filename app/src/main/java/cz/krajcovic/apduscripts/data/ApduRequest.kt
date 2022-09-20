package cz.krajcovic.apduscripts.data

import cz.krajcovic.apduscripts.decorators.toHexString

/**
 * Příkaz APDU
 */
data class ApduRequest(
    // Instrukční třída – určuje typ příkazu, např. interindustry nebo proprietary
    val cla: Byte,

    // Instrukční kód – určuje konkrétní příkaz, např. "write data"
    val ins: Byte,

    // instrukční parametry příkazu, např. offset v souboru pro zápis dat
    // 1B
    val p1: Byte,

    // instrukční parametry příkazu, např. offset v souboru pro zápis dat
    // 1B
    val p2: Byte,

    // Kóduje (Nc) bytů následujících dat příkazu
    // 0-1-3B
    val lc: Int,

    // Nc bytů dat
    val nc: ByteArray,

    // Kóduje maximálně (Ne) bytů očekávané odpovědi
    // 0-1-3B
    val le: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ApduRequest

        if (cla != other.cla) return false
        if (ins != other.ins) return false
        if (p1 != other.p1) return false
        if (p2 != other.p2) return false
        if (lc != other.lc) return false
        if (!nc.contentEquals(other.nc)) return false
        if (le != other.le) return false

        return true
    }

    override fun hashCode(): Int {
        var result : Int = cla.toInt()
        result = 31 * result + ins
        result = 31 * result + p1
        result = 31 * result + p2
        result = 31 * result + lc
        result = 31 * result + nc.contentHashCode()
        result = 31 * result + le
        return result
    }

    override fun toString(): String {
        return "ApduRequest(cla=${cla.toHexString()}, ins=${ins.toHexString()}, p1=${p1.toHexString()}, p2=${p2.toHexString()}, lc=$lc[$lc.], nc=${nc.toHexString()}, le=$le)"
    }


}
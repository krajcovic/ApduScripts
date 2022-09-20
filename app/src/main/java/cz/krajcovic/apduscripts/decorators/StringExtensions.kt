package cz.krajcovic.apduscripts.decorators

/**
 *
 */
fun String.decodeHex(): ByteArray {
    check(length % 2 == 0) { "Must have an even length" }

    return chunked(2)
        .map { it.toInt(16).toByte() }
        .toByteArray()
}

/**
 *
 */
fun String.toBcd(): ByteArray {
    val result = mutableListOf<Byte>()

    val source = if (length % 2 == 0) this else "0$this"

    var x = 0
    source.forEachIndexed { index, c ->
        val isFirstPosition = index % 2 == 0
        x += if (c.isDigit()) {
            (c - '0') * if (isFirstPosition) 16 else 1
        } else {
            (c.toLowerCase() - 'a' + 10) * if (isFirstPosition) 16 else 1
        }

        if (!isFirstPosition) {
            result.add(x.toByte())
            x = 0
        }
    }

    return result.toByteArray()
}

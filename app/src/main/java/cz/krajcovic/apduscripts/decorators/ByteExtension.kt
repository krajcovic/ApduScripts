package cz.krajcovic.apduscripts.decorators

fun ByteArray?.toHexString(): String =
    if (this == null) {
        ""
    } else {
        StringBuilder().also {
            forEach { byte ->
                it.append(String.format("%02X", byte))
            }
        }.toString()
    }

fun Byte?.toHexString(): String =
    if (this == null) {
        ""
    } else {
        StringBuilder().also {
            it.append(String.format("%02X", this))
        }.toString()
    }
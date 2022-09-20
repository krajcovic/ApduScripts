package cz.krajcovic.apduscripts.decorators

import java.nio.ByteBuffer
import java.nio.ByteOrder

fun Int.lenghByte(): Int {
    if (this <= 0xFF)
        return 1
    if (this <= 0xFFFF)
        return 2
    if (this <= 0xFFFFFF)
        return 3

    return Int.SIZE_BYTES
}

fun Int.to2ByteArray(): ByteArray {
    val buffer = ByteBuffer.allocate(Int.SIZE_BYTES)
    buffer.order(ByteOrder.BIG_ENDIAN) // BIG_ENDIAN is default byte order, so it is not necessary.
    buffer.putInt(this)

    return buffer.array().copyOfRange(Int.SIZE_BYTES - this.lenghByte(), Int.SIZE_BYTES)
}
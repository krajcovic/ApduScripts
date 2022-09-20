package cz.krajcovic.apduscripts.decorators

import java.nio.ByteBuffer
import java.nio.ByteOrder

fun Long.lenghByte(): Int {
    if(this <= 0xFF)
        return 1
    if(this <= 0xFFFF)
        return 2
    if(this <= 0xFFFFFF)
        return 3
    if(this <= 0xFFFFFFFF)
        return 4
    if(this <= 0xFFFFFFFFFF)
        return 5
    if(this <= 0xFFFFFFFFFFFF)
        return 6
    if(this <= 0xFFFFFFFFFFFFFF)
        return 7

    return Long.SIZE_BYTES
}

fun Long.to2ByteArray(): ByteArray {
    val buffer = ByteBuffer.allocate(Long.SIZE_BYTES)
    buffer.order(ByteOrder.BIG_ENDIAN) // BIG_ENDIAN is default byte order, so it is not necessary.
    buffer.putLong(this)

    return buffer.array().copyOfRange(Long.SIZE_BYTES - this.lenghByte(), Long.SIZE_BYTES)
}
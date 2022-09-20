package cz.krajcovic.apduscripts.decorators

import org.junit.Assert.*

import org.junit.Test

class IntExtensionsKtTest {
    @Test
    fun to2ByteArray1() {
        assertArrayEquals(byteArrayOf(0x00), 0.to2ByteArray())
    }

    @Test
    fun to2ByteArray2() {
        assertArrayEquals(byteArrayOf(0xFF.toByte(), 0xFF.toByte()), 0xFFFF.to2ByteArray())
    }

    @Test
    fun to2ByteArray3() {
        assertArrayEquals(byteArrayOf(0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()), 0xFFFFFF.to2ByteArray())
    }

    @Test
    fun to2ByteArray4() {
        assertArrayEquals(byteArrayOf(0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()), 0xFFFFFFFF.to2ByteArray())
    }
    @Test
    fun to2ByteArrayMax() {
        assertArrayEquals(byteArrayOf(0x7F.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()), 0x7FFFFFFF.to2ByteArray())
    }


}
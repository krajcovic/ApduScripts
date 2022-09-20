package cz.krajcovic.apduscripts.decorators

import org.junit.Assert.*

import org.junit.Test

class LongExtensionsKtTest {

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
    fun to2ByteArray5() {
        assertArrayEquals(byteArrayOf(0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()), 0xFFFFFFFFFF.to2ByteArray())
    }

    @Test
    fun to2ByteArray6() {
        assertArrayEquals(byteArrayOf(0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()), 0xFFFFFFFFFFFF.to2ByteArray())
    }

    @Test
    fun to2ByteArray7() {
        assertArrayEquals(byteArrayOf(0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()), 0xFFFFFFFFFFFFFF.to2ByteArray())
    }

    @Test
    fun to2ByteArray8() {
        assertArrayEquals(byteArrayOf(0x7F.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()), Long.MAX_VALUE.to2ByteArray())
    }
}
package cz.krajcovic.apduscripts.decorators

import org.junit.Assert.*

import org.junit.Test

class StringExtensionsKtTest {

    @Test
    fun decodeHex() {
        assertArrayEquals(
            byteArrayOf( 0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77,
                0x88.toByte(), 0x99.toByte(), 0xAA.toByte(), 0xBB.toByte(),
                0xCC.toByte(), 0xDD.toByte(), 0xEE.toByte(), 0xFF.toByte()
            ),
            "00112233445566778899AABBCCDDEEFF".decodeHex()
        )
    }

    @Test
    fun toBcd() {
        assertArrayEquals(
            byteArrayOf( 0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77,
                0x88.toByte(), 0x99.toByte(), 0xAA.toByte(), 0xBB.toByte(),
                0xCC.toByte(), 0xDD.toByte(), 0xEE.toByte(), 0xFF.toByte()
            ),
            "00112233445566778899AABBCCDDEEFF".toBcd()
        )
    }
}
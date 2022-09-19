package cz.krajcovic.apduscripts.models

import cz.krajcovic.apduscripts.data.ApduMessage
import cz.krajcovic.apduscripts.data.ApduRequest
import cz.krajcovic.apduscripts.data.ApduResponse
import cz.krajcovic.apduscripts.decorators.decodeHex

class ApduMessagesFactory {

    companion object {

        private fun getApduRequest(): ApduRequest {
            val aid ="A00000000401".decodeHex()
            return ApduRequest(0x00, 0xA4.toByte(), 0x00, 0x00, aid.size, aid, 0xFF)
        }

        private fun getApduResponse(): ApduResponse {
            return ApduResponse("00010203".decodeHex(), 0x90.toByte(), 0x00)
        }

        fun getFake(): ApduMessage {
            return ApduMessage("Random generated apdu",
                getApduRequest(),
                getApduResponse()
            )
        }
    }


}
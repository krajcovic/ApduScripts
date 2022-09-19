package cz.krajcovic.apduscripts.data

data class ApduMessage(val name:String, val apduRequest: ApduRequest?, val apduResponse: ApduResponse?) {
    constructor(name: String) : this(name, null, null)
    constructor(name: String, apduRequest: ApduRequest) : this(name, apduRequest, null)
    constructor(name: String, apduResponse: ApduResponse) : this(name, null, apduResponse)
}

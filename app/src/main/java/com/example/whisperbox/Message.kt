package com.example.whisperbox

class Message {
    var message: String? = null
    var senderId: String? = null

    constructor() {
        //null
    }

    constructor(message: String?, senderId: String?) {
        this.message = message
        this.senderId = senderId

    }
}
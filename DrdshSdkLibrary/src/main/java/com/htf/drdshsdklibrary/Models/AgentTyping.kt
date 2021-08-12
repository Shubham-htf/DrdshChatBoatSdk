package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class AgentTyping:Serializable {

    @SerializedName("vid")
    @Expose
    var vid: String? = null

    @SerializedName("ts")
    @Expose
    var ts: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("stop")
    @Expose
    var stop: Boolean? = null

    @SerializedName("device")
    @Expose
    var device: String? = null

    @SerializedName("locale")
    @Expose
    var locale: String? = null
    
}
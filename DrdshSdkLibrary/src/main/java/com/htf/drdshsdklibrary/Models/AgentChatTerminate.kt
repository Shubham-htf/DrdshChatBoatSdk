package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class AgentChatTerminate:Serializable {

    @SerializedName("vid")
    @Expose
    var vid: String? = null

    @SerializedName("agent_id")
    @Expose
    var agentId: String? = null

    @SerializedName("device")
    @Expose
    var device: String? = null

    @SerializedName("locale")
    @Expose
    var locale: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("log")
    @Expose
    var log: String? = null


}
package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class AgentAcceptChat:Serializable {

    @SerializedName("mid")
    @Expose
    var mid: String? = null

    @SerializedName("vid")
    @Expose
    var vid: String? = null

    @SerializedName("agent_id")
    @Expose
    var agentId: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("agent_name")
    @Expose
    var agentName: String? = null

    @SerializedName("agent_image")
    @Expose
    var agentImage: String? = null

    @SerializedName("visitor_name")
    @Expose
    var visitorName: String? = null

    @SerializedName("log")
    @Expose
    var log: String? = null

    @SerializedName("user_log")
    @Expose
    var userLog: String? = null

    @SerializedName("vd")
    @Expose
    var vd: JoinChatRoom? = null

}
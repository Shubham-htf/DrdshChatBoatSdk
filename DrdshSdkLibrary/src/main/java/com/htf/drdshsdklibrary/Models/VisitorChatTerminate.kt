package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class VisitorChatTerminate:Serializable {
    @SerializedName("vid")
    @Expose
    var vid: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("comment")
    @Expose
    var comment: String? = null

    @SerializedName("feedback")
    @Expose
    var feedback: String? = null

    @SerializedName("appSid")
    @Expose
    var appSid: String? = null

    @SerializedName("device")
    @Expose
    var device: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("log")
    @Expose
    var log: String? = null
}
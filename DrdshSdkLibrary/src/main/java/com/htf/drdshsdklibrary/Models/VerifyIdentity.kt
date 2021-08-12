package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class VerifyIdentity:Serializable {
    @SerializedName("companyId")
    @Expose
    var companyId: String? = null

    @SerializedName("agentOnline")
    @Expose
    var agentOnline: Int? = null

    @SerializedName("visitorConnectedStatus")
    @Expose
    var visitorConnectedStatus: Int? = null

    @SerializedName("agentId")
    @Expose
    var agentId: Any? = null

    @SerializedName("visitorID")
    @Expose
    var visitorID: String? = null

    @SerializedName("isBlocked")
    @Expose
    var isBlocked: Int? = null

    @SerializedName("embeddedChat")
    @Expose
    var embeddedChat: EmbeddedChat? = null

}
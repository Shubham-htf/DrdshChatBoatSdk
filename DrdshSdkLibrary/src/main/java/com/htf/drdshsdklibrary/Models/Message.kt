package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.File
import java.io.Serializable


class Message:Serializable {
    var messageType=0
    var messageInfoTypeShowLoading=false
    var isLocal=false
    var messageLocalTime=""

    @SerializedName("company_id")
    @Expose
    var companyId: String? = null

    @SerializedName("visitor_id")
    @Expose
    var visitorId: VisitorId? = null

    @SerializedName("agent_id")
    @Expose
    var agentId: AgentId? = null

    @SerializedName("agent_name")
    @Expose
    var agentName: String? = null

    @SerializedName("agent_image")
    @Expose
    var agentImage: String? = null

    @SerializedName("new_agent_id")
    @Expose
    var newAgentId: AgentId? = null

    @SerializedName("new_agent_name")
    @Expose
    var newAgentName: Any? = null

    @SerializedName("new_agent_image")
    @Expose
    var newAgentImage: Any? = null

    @SerializedName("visitor_message_id")
    @Expose
    var visitorMessageId: String? = null

    @SerializedName("localId")
    @Expose
    var localId: String? = null

    @SerializedName("isTransfer")
    @Expose
    var isTransfer: Boolean? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("attachment_file")
    @Expose
    var attachmentFile: String? = null

    @SerializedName("file_type")
    @Expose
    var fileType: String? = null

    @SerializedName("file_size")
    @Expose
    var fileSize: Any? = null

    @SerializedName("formatted_file_size")
    @Expose
    var formattedFileSize: Any? = null

    @SerializedName("send_by")
    @Expose
    var sendBy: Int? = null

    @SerializedName("is_attachment")
    @Expose
    var isAttachment: Int? = null

    @SerializedName("isWelcome")
    @Expose
    var isWelcome: Boolean? = null

    @SerializedName("isSystem")
    @Expose
    var isSystem: Boolean? = null

    @SerializedName("isDeleted")
    @Expose
    var isDeleted: Boolean? = null

    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

    var tempFile: File?=null

    @SerializedName("deliveredAt")
    @Expose
    var deliveredAt: String? = ""

    @SerializedName("readAt")
    @Expose
    var readAt: String? = ""

    
}
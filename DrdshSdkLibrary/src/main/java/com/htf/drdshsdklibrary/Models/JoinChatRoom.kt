package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class JoinChatRoom:Serializable {
    @SerializedName("company_id")
    @Expose
    var companyId: String? = null

    @SerializedName("company_name")
    @Expose
    var companyName: String? = null

    @SerializedName("visitor_message_id")
    @Expose
    var visitorMessageId: String? = null

    @SerializedName("account_id")
    @Expose
    var accountId: Any? = null

    @SerializedName("ip_address")
    @Expose
    var ipAddress: String? = null

    @SerializedName("location")
    @Expose
    var location: Any? = null

    @SerializedName("localIp")
    @Expose
    var localIp: Any? = null

    @SerializedName("browser")
    @Expose
    var browser: String? = null

    @SerializedName("domain")
    @Expose
    var domain: String? = null

    @SerializedName("language")
    @Expose
    var language: Any? = null

    @SerializedName("source")
    @Expose
    var source: String? = null

    @SerializedName("appCodeName")
    @Expose
    var appCodeName: String? = null

    @SerializedName("appName")
    @Expose
    var appName: Any? = null

    @SerializedName("appVersion")
    @Expose
    var appVersion: Any? = null

    @SerializedName("platform")
    @Expose
    var platform: Any? = null

    @SerializedName("product")
    @Expose
    var product: Any? = null

    @SerializedName("productSub")
    @Expose
    var productSub: Any? = null

    @SerializedName("vendor")
    @Expose
    var vendor: Any? = null

    @SerializedName("timeZone")
    @Expose
    var timeZone: String? = null

    @SerializedName("timeZoneOffset")
    @Expose
    var timeZoneOffset: Any? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("countryCode")
    @Expose
    var countryCode: String? = null

    @SerializedName("region")
    @Expose
    var region: String? = null

    @SerializedName("regionName")
    @Expose
    var regionName: String? = null

    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("zip")
    @Expose
    var zip: String? = null

    @SerializedName("lat")
    @Expose
    var lat: String? = null

    @SerializedName("lon")
    @Expose
    var lon: String? = null

    @SerializedName("timezone")
    @Expose
    var timezone: String? = null

    @SerializedName("isp")
    @Expose
    var isp: String? = null

    @SerializedName("org")
    @Expose
    var org: String? = null

    @SerializedName("as")
    @Expose
    var `as`: String? = null

    @SerializedName("full_url")
    @Expose
    var fullUrl: String? = null

    @SerializedName("visitor_subject")
    @Expose
    var visitorSubject: String? = null

    @SerializedName("resolution")
    @Expose
    var resolution: String? = null

    @SerializedName("expandWidth")
    @Expose
    var expandWidth: String? = null

    @SerializedName("expendHeight")
    @Expose
    var expendHeight: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("mobile")
    @Expose
    var mobile: String? = null

    @SerializedName("total_visits")
    @Expose
    var totalVisits: Int? = null

    @SerializedName("total_chats")
    @Expose
    var totalChats: Int? = null

    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("agent_id")
    @Expose
    var agentId: Any? = null

    @SerializedName("agent_name")
    @Expose
    var agentName: String? = null

    @SerializedName("agent_image")
    @Expose
    var agentImage: Any? = null

    @SerializedName("invitedAt")
    @Expose
    var invitedAt: Any? = null

    @SerializedName("invitationAcceptedAt")
    @Expose
    var invitationAcceptedAt: Any? = null

    @SerializedName("waitingDuration")
    @Expose
    var waitingDuration: Int? = null

    @SerializedName("chatStartedAt")
    @Expose
    var chatStartedAt: Any? = null

    @SerializedName("chatEndAt")
    @Expose
    var chatEndAt: Any? = null

    @SerializedName("chatDuration")
    @Expose
    var chatDuration: Int? = null

    @SerializedName("isActive")
    @Expose
    var isActive: Boolean? = null

    @SerializedName("isActiveChangeAt")
    @Expose
    var isActiveChangeAt: String? = null

    @SerializedName("log")
    @Expose
    var log: String? = null

    @SerializedName("restart")
    @Expose
    var restart: Any? = null

    @SerializedName("transferLog")
    @Expose
    var transferLog: Any? = null

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
}
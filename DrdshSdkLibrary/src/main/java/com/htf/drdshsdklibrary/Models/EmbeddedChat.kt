package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class EmbeddedChat:Serializable {

    @SerializedName("ChatButtonIcon")
    @Expose
    var chatButtonIcon: String? = null

    @SerializedName("eyeCatcher")
    @Expose
    var eyeCatcher: String? = null

    @SerializedName("eyeCatcherCloseIcon")
    @Expose
    var eyeCatcherCloseIcon: String? = null

    @SerializedName("template_class")
    @Expose
    var templateClass: String? = null

    @SerializedName("position")
    @Expose
    var position: String? = null

    @SerializedName("expandWidth")
    @Expose
    var expandWidth: String? = null

    @SerializedName("expendHeight")
    @Expose
    var expendHeight: String? = null

    @SerializedName("onlineTxt")
    @Expose
    var onlineTxt: String? = null

    @SerializedName("offlineTxt")
    @Expose
    var offlineTxt: String? = null

    @SerializedName("topBarFontSize")
    @Expose
    var topBarFontSize: String? = null

    @SerializedName("topBarFontFamily")
    @Expose
    var topBarFontFamily: String? = null

    @SerializedName("topBarTxtColor")
    @Expose
    var topBarTxtColor: String? = null

    @SerializedName("topBarBgColor")
    @Expose
    var topBarBgColor: String? = null

    @SerializedName("buttonBorderColor")
    @Expose
    var buttonBorderColor: String? = null

    @SerializedName("buttonBorder")
    @Expose
    var buttonBorder: String? = null

    @SerializedName("showHeaderImg")
    @Expose
    var showHeaderImg: Int? = null

    @SerializedName("chatHeaderImg")
    @Expose
    var chatHeaderImg: String? = null

    @SerializedName("offlineHeaderImg")
    @Expose
    var offlineHeaderImg: String? = null

    @SerializedName("greetingFontColor")
    @Expose
    var greetingFontColor: String? = null

    @SerializedName("greetingFontSize")
    @Expose
    var greetingFontSize: String? = null

    @SerializedName("fontFamily")
    @Expose
    var fontFamily: String? = null

    @SerializedName("bgColor")
    @Expose
    var bgColor: String? = null

    @SerializedName("labelColor")
    @Expose
    var labelColor: String? = null

    @SerializedName("valueColor")
    @Expose
    var valueColor: String? = null

    @SerializedName("buttonColor")
    @Expose
    var buttonColor: String? = null

    @SerializedName("buttonFontSize")
    @Expose
    var buttonFontSize: String? = null

    @SerializedName("showAgentPanel")
    @Expose
    var showAgentPanel: Int? = null

    @SerializedName("showAgentPhoto")
    @Expose
    var showAgentPhoto: Int? = null

    @SerializedName("showBrandPhoto")
    @Expose
    var showBrandPhoto: Int? = null

    @SerializedName("brandPhotoURL")
    @Expose
    var brandPhotoURL: String? = null

    @SerializedName("showSendTranscriptButton")
    @Expose
    var showSendTranscriptButton: Int? = null

    @SerializedName("showSoundOnOffButton")
    @Expose
    var showSoundOnOffButton: Int? = null

    @SerializedName("showFeedbackButton")
    @Expose
    var showFeedbackButton: Int? = null

    @SerializedName("showAttachmentButton")
    @Expose
    var showAttachmentButton: Int? = null

    @SerializedName("showEmojiButton")
    @Expose
    var showEmojiButton: Int? = null

    @SerializedName("showTimestampsChatWindow")
    @Expose
    var showTimestampsChatWindow: Int? = null

    @SerializedName("visitorNameColor")
    @Expose
    var visitorNameColor: String? = null

    @SerializedName("visitorNameFont")
    @Expose
    var visitorNameFont: String? = null

    @SerializedName("visitorNameSize")
    @Expose
    var visitorNameSize: String? = null

    @SerializedName("visitorMessageColor")
    @Expose
    var visitorMessageColor: String? = null

    @SerializedName("visitorMessageFont")
    @Expose
    var visitorMessageFont: String? = null

    @SerializedName("visitorMessageSize")
    @Expose
    var visitorMessageSize: String? = null

    @SerializedName("agentNameColor")
    @Expose
    var agentNameColor: String? = null

    @SerializedName("agentNameFont")
    @Expose
    var agentNameFont: String? = null

    @SerializedName("agentNameSize")
    @Expose
    var agentNameSize: String? = null

    @SerializedName("agentMessageColor")
    @Expose
    var agentMessageColor: String? = null

    @SerializedName("agentMessageFont")
    @Expose
    var agentMessageFont: String? = null

    @SerializedName("agentMessageSize")
    @Expose
    var agentMessageSize: String? = null

    @SerializedName("timestampColor")
    @Expose
    var timestampColor: String? = null

    @SerializedName("timestampFont")
    @Expose
    var timestampFont: String? = null

    @SerializedName("timestampSize")
    @Expose
    var timestampSize: String? = null

    @SerializedName("systemMessageColor")
    @Expose
    var systemMessageColor: String? = null

    @SerializedName("systemMessageFont")
    @Expose
    var systemMessageFont: String? = null

    @SerializedName("systemMessageSize")
    @Expose
    var systemMessageSize: String? = null

    @SerializedName("displayForm")
    @Expose
    var displayForm: Int? = null

    @SerializedName("maxWaitTime")
    @Expose
    var maxWaitTime: String? = null

    @SerializedName("chatRequestTimeoutShowOfflineForm")
    @Expose
    var chatRequestTimeoutShowOfflineForm: Int? = null

    @SerializedName("emailRequired")
    @Expose
    var emailRequired: Int? = null

    @SerializedName("mobileRequired")
    @Expose
    var mobileRequired: Int? = null

    @SerializedName("messageRequired")
    @Expose
    var messageRequired: Int? = null

    @SerializedName("preChatNotifyEmailAddress")
    @Expose
    var preChatNotifyEmailAddress: Any? = null

    @SerializedName("showExitSurvey")
    @Expose
    var showExitSurvey: Int? = null

    @SerializedName("postChatPromptComments")
    @Expose
    var postChatPromptComments: Int? = null

    @SerializedName("offlineMessageOptions")
    @Expose
    var offlineMessageOptions: Int? = null

    @SerializedName("offlineMessageNotifyEmails")
    @Expose
    var offlineMessageNotifyEmails: String? = null

    @SerializedName("offlineMessageRedirectUrl")
    @Expose
    var offlineMessageRedirectUrl: String? = null

    @SerializedName("offlineMsgShowSubjectBox")
    @Expose
    var offlineMsgShowSubjectBox: Int? = null

    @SerializedName("offlineMsgShowMobileBox")
    @Expose
    var offlineMsgShowMobileBox: Int? = null

    @SerializedName("offlineMsgShowAgentConsole")
    @Expose
    var offlineMsgShowAgentConsole: Int? = null

    @SerializedName("offlineMsgAdminCanView")
    @Expose
    var offlineMsgAdminCanView: Int? = null

    @SerializedName("offlineMsgDoDotSaveEmailOnly")
    @Expose
    var offlineMsgDoDotSaveEmailOnly: Int? = null

    @SerializedName("chatLocale")
    @Expose
    var chatLocale: String? = null

    @SerializedName("fieldLabelName")
    @Expose
    var fieldLabelName: String? = null

    @SerializedName("fieldLabelEmail")
    @Expose
    var fieldLabelEmail: String? = null

    @SerializedName("fieldLabelSubject")
    @Expose
    var fieldLabelSubject: String? = null

    @SerializedName("fieldLabelMessage")
    @Expose
    var fieldLabelMessage: String? = null

    @SerializedName("fieldLabelMobile")
    @Expose
    var fieldLabelMobile: String? = null

    @SerializedName("fieldPlaceholderName")
    @Expose
    var fieldPlaceholderName: String? = null

    @SerializedName("fieldPlaceholderEmail")
    @Expose
    var fieldPlaceholderEmail: String? = null

    @SerializedName("fieldPlaceholderSubject")
    @Expose
    var fieldPlaceholderSubject: String? = null

    @SerializedName("fieldPlaceholderMessage")
    @Expose
    var fieldPlaceholderMessage: String? = null

    @SerializedName("fieldPlaceholderMobile")
    @Expose
    var fieldPlaceholderMobile: String? = null

    @SerializedName("preChatOnlineMessageTxt")
    @Expose
    var preChatOnlineMessageTxt: String? = null

    @SerializedName("preChatOfflineMessageTxt")
    @Expose
    var preChatOfflineMessageTxt: String? = null

    @SerializedName("onHoldMsg")
    @Expose
    var onHoldMsg: String? = null

    @SerializedName("startChatButtonTxt")
    @Expose
    var startChatButtonTxt: String? = null

    @SerializedName("sendButtonTxt")
    @Expose
    var sendButtonTxt: String? = null

    @SerializedName("cancelButtonTxt")
    @Expose
    var cancelButtonTxt: String? = null

    @SerializedName("exitSurveyCommentTxt")
    @Expose
    var exitSurveyCommentTxt: String? = null

    @SerializedName("exitSurveyHeaderTxt")
    @Expose
    var exitSurveyHeaderTxt: String? = null

    @SerializedName("exitSurveyMessageTxt")
    @Expose
    var exitSurveyMessageTxt: String? = null

    @SerializedName("exitSurveySendButtonTxt")
    @Expose
    var exitSurveySendButtonTxt: String? = null

    @SerializedName("exitSurveyCloseButtonTxt")
    @Expose
    var exitSurveyCloseButtonTxt: String? = null

    @SerializedName("restartChatButtonTxt")
    @Expose
    var restartChatButtonTxt: String? = null

    @SerializedName("dropOfflineMessageButtonTxt")
    @Expose
    var dropOfflineMessageButtonTxt: String? = null

    @SerializedName("topFrameBackgroundColor")
    @Expose
    var topFrameBackgroundColor: String? = null

    @SerializedName("messengerBodyImage")
    @Expose
    var messengerBodyImage: String? = null

    @SerializedName("agentMessageBackgroundColor")
    @Expose
    var agentMessageBackgroundColor: String? = null

    @SerializedName("visitorMessageBackgroundColor")
    @Expose
    var visitorMessageBackgroundColor: String? = null

    @SerializedName("visitorDefaultImage")
    @Expose
    var visitorDefaultImage: String? = null

    @SerializedName("rateGoodText")
    @Expose
    var rateGoodText: String? = null

    @SerializedName("rateBadText")
    @Expose
    var rateBadText: String? = null

    @SerializedName("emailChatTranscriptText")
    @Expose
    var emailChatTranscriptText: String? = null

    @SerializedName("soundOnText")
    @Expose
    var soundOnText: String? = null

    @SerializedName("soundOffText")
    @Expose
    var soundOffText: String? = null

    @SerializedName("emojiText")
    @Expose
    var emojiText: String? = null

    @SerializedName("attachmentText")
    @Expose
    var attachmentText: String? = null

    @SerializedName("sendMessageText")
    @Expose
    var sendMessageText: String? = null

    @SerializedName("messageSendPlaceholderText")
    @Expose
    var messageSendPlaceholderText: String? = null

    @SerializedName("defaultVisitorNameText")
    @Expose
    var defaultVisitorNameText: String? = null

    @SerializedName("systemMessageBackgroundColor")
    @Expose
    var systemMessageBackgroundColor: String? = null

    @SerializedName("buttonTextColor")
    @Expose
    var buttonTextColor: String? = null

    @SerializedName("minimizeText")
    @Expose
    var minimizeText: String? = null

    @SerializedName("maximizeText")
    @Expose
    var maximizeText: String? = null

    @SerializedName("endChatSessionText")
    @Expose
    var endChatSessionText: String? = null

    @SerializedName("agentNameTextColor")
    @Expose
    var agentNameTextColor: String? = null

    @SerializedName("systemMessageBorderColor")
    @Expose
    var systemMessageBorderColor: String? = null

    @SerializedName("agentMessageBorderColor")
    @Expose
    var agentMessageBorderColor: String? = null

    @SerializedName("visitorMessageBorderColor")
    @Expose
    var visitorMessageBorderColor: String? = null

    @SerializedName("hidePoweredBy")
    @Expose
    var hidePoweredBy: Int? = null
}
package com.htf.drdshsdklibrary.Utills

object Constants {

    const val BASE_URL="https://www.drdsh.live"
    const val API_URL="${BASE_URL}/sdk/v1/"
    const val TYPE_DISLIKE=1
    const val TYPE_LIKE=2

    const val ATTACHMENT_URL="$BASE_URL/uploads/m/"
    const val ATTACHMENT_MESSAGE_URL="$BASE_URL/uploads/messenger-image/"


    const val KEY_PREF_USER_LANGUAGE="language"

    const val AGENT_IMAGE_URL="${BASE_URL}/uploads/images/"

    const val IS_AGENT_ONLINE=1
    const val IS_AGENT_OFFLINE=0

    const val MESSAGE_TYPE_SENT=1
    const val MESSAGE_TYPE_RECEIVED=2
    const val MESSAGE_TYPE_INFO=3

    const val ACTION_AGENT_ACCEPT_CHAT_REQUEST="agent_accept_chat_request"

    const val CHAT_IN_NORMAL_MODE=0
    const val CHAT_IN_WAITING_MODE=1
    const val CHAT_IN_CONNECTED_MODE=2

    const val AGENT_TYPING_START=1
    const val AGENT_IS_TYPING=2

    const val ATTACHMENT_MESSAGE=1
    const val NORMAL_MESSAGE=0

    const val FROM_AGENT=1
    const val FROM_ME=2

    const val ALERT_TYPE_CLOSE_CHAT=1
    const val ALERT_TYPE_CHAT_RATING=2
    const val ALERT_TYPE_SEND_EMAIL=3


    const val IMAGE="image"

}
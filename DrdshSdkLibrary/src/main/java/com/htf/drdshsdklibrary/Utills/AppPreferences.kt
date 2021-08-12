package com.htf.learnchinese.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.htf.drdshsdklibrary.Models.JoinChatRoom
import com.htf.drdshsdklibrary.Models.VerifyIdentity
import com.htf.drdshsdklibrary.R
class AppPreferences private constructor() {
    /* CLASS SESSION */
    companion object {
        private var mInstance: AppPreferences? = null
        private var mPreferences: SharedPreferences? = null
        private var mEditor: SharedPreferences.Editor? = null


        const val KEY_IDENTITY_DETAILS="verify_identity"
        const val KEY_JOIN_CHAT_ROOM_DETAILS="join_chat_room"

        fun getInstance(context: Context): AppPreferences {
            if (mInstance == null) {
                mInstance = AppPreferences()
            }
            if (mPreferences == null) {
                mPreferences = context.getSharedPreferences(
                    context.getString(R.string.app_name),
                    Context.MODE_PRIVATE
                )
                mEditor = mPreferences!!.edit()
            }
            return mInstance as AppPreferences
        }
    }

    /* Class Functions */
    fun saveInPreference(key: String, value: String) {
        mEditor!!.putString(key, value)
        mEditor!!.commit()
    }

    fun getFromPreference(key: String): String? {
        return mPreferences!!.getString(key, "")
    }

    fun saveInPreference(key: String, value: Boolean) {
        mEditor!!.putBoolean(key, value)
        mEditor!!.commit()
    }

    fun getBooleanFromPreference(key: String): Boolean {
        return mPreferences!!.getBoolean(key, false)
    }


    fun saveIdentityDetails(verifyIdentity: VerifyIdentity) {
        mEditor!!.putString(KEY_IDENTITY_DETAILS, Gson().toJson(verifyIdentity))
        mEditor!!.commit()
    }

    fun getIdentityDetails(): VerifyIdentity? {
        val userJson = mPreferences!!.getString(KEY_IDENTITY_DETAILS, "")
        var verifyIdentity:VerifyIdentity? = null
        if (userJson != null && userJson != "") {
            verifyIdentity = Gson().fromJson(userJson, VerifyIdentity::class.java)
        }
        return verifyIdentity
    }

    fun clearUserDetails() {
        mEditor!!.putString(KEY_IDENTITY_DETAILS, "")
        mEditor!!.commit()
    }

    fun saveJoinChatRoomDetails(joinChatRoom: JoinChatRoom) {
        mEditor!!.putString(KEY_JOIN_CHAT_ROOM_DETAILS, Gson().toJson(joinChatRoom))
        mEditor!!.commit()
    }

    fun getJoinChatRoomDetails(): JoinChatRoom? {
        val userJson = mPreferences!!.getString(KEY_JOIN_CHAT_ROOM_DETAILS, "")
        var joinChatRoom:JoinChatRoom? = null
        if (userJson != null && userJson != "") {
            joinChatRoom = Gson().fromJson(userJson, JoinChatRoom::class.java)
        }
        return joinChatRoom
    }

    fun getJoinChatRoomDetailsInString(): String? {
        return mPreferences!!.getString(KEY_JOIN_CHAT_ROOM_DETAILS, "")
    }

    fun clearJoinChatRoomDetails() {
        mEditor!!.putString(KEY_JOIN_CHAT_ROOM_DETAILS, "")
        mEditor!!.commit()
    }

}

package com.htf.learnchinese.utils


import android.provider.Settings
import com.github.nkzawa.socketio.client.Socket
import com.htf.drdshsdklibrary.Utills.MyApplication

class AppSession {

    companion object {
        var userTokenIsValid: Boolean =false
        var locale = "en"
        var userToken = ""
        var isLocaleEnglish: Boolean = true
        var mSocket: Socket? = null
        var deviceType = "android"
        var account_type ="1"
        var app_currency =""
        var cameraPermission: Boolean=false
        var checkLocationPermission: Boolean=false
        var checkBookingPageOpen = false
        var dial_Code="966"
        var shipmentDiscountPercentage=0
        var appSid=""

    }
}
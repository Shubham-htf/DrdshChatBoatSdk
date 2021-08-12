package com.htf.drdshsdklibrary.Utills

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.htf.drdshsdklibrary.R

import java.util.*

/**
 *
 */
open class LocalizeDarkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }
        //setLocale()
    }

    /*protected fun setLocale() {
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration

        val savedLanguage = AppPreferences.getInstance(this).getFromPreference(KEY_PREF_USER_LANGUAGE)

        AppSession.deviceId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)

        if (savedLanguage != null) {
            when (savedLanguage) {
                "en" -> {
                    conf.setLocale(Locale("en"))
                    AppSession.locale = "en"
                    AppSession.isLocaleEnglish = true
                }
                "ar" -> {
                    conf.setLocale(Locale("ar"))
                    AppSession.locale = "ar"
                    AppSession.isLocaleEnglish = false
                }
                else -> {
                    conf.setLocale(Locale("ar"))
                    AppSession.locale = "ar"
                    AppSession.isLocaleEnglish = false
                }
            }
            res.updateConfiguration(conf, dm)
        }
    }*/


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

       /* val v = currentFocus

        if (v != null &&
                (ev.action == MotionEvent.ACTION_UP || ev.action == MotionEvent.ACTION_MOVE) &&
                v is EditText &&
                !v.javaClass.name.startsWith("android.webkit.")) {
            val scrcoords = IntArray(2)
            v.getLocationOnScreen(scrcoords)
            val x = ev.rawX + v.left - scrcoords[0]
            val y = ev.rawY + v.top - scrcoords[1]

            if (x < v.left || x > v.right || y < v.top || y > v.bottom)
                AppUtils.hideKeyboard(this)
        }*/
        return super.dispatchTouchEvent(ev)
    }

    override fun onBackPressed() {
        super.onBackPressed()
//        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_left)
    }

}
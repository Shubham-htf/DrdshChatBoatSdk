package com.htf.drdshsdklibrary.Utills

import android.app.Application
import android.content.Context

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        setAppContext(this)

    }

    companion object {
        private lateinit var instance: MyApplication
        private lateinit var mAppContext: Context

        fun getInstance(): MyApplication {
            return instance
        }

        fun getAppContext(): Context {
            return mAppContext
        }

        fun setAppContext(mAppContext: Context) {
            Companion.mAppContext = mAppContext
        }
    }

}
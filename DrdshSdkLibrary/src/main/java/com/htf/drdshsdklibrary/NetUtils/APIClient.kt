package com.htf.drdshsdklibrary.NetUtils


import android.app.Activity
import android.app.Dialog
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import com.htf.drdshsdklibrary.R
import com.htf.drdshsdklibrary.Utills.AppUtils
import com.htf.drdshsdklibrary.Utills.Constants

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


class APIClient {

    companion object {
        var isRefreshingToken = false
        fun getClient(): ApiInterface {

            val logging = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                .setLevel(HttpLoggingInterceptor.Level.BODY)


            val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(logging)
                .addInterceptor { chain ->
                    val originalRequest = chain.request()
                    val builder = originalRequest.newBuilder()
                        .header("X-Requested-With", "XMLHttpRequest")


                    val newRequest = builder.build()

                    chain.proceed(newRequest)
                }
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }


        fun getResponse(
            call: Call<String>, activity: Activity, fragment: Fragment?, showProgress: Boolean,
            retrofitResponse: RetrofitResponse
        ): Boolean {

            if (!AppUtils.isInternetOn(activity, fragment, 4993))
                return false

            var dialog: Dialog? = null
            if (showProgress) {
                dialog = AppUtils.showProgress(activity)
            }

            if (isRefreshingToken) {
                Handler().postDelayed({
                    getResponse(call, activity, fragment, showProgress, retrofitResponse)
                }, 5000)
                return true
            }
            val finalDialog = dialog

            call.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    if (showProgress && finalDialog != null)
                        if (finalDialog.isShowing) {
                            AppUtils.hideProgress(finalDialog)
                        }

                    if (response!!.isSuccessful) {
                        val serverResponse = response.body().toString()
                        retrofitResponse.onResponse(serverResponse)
                        Log.e("ServerResponse", "$serverResponse!")
                    } else {
                        retrofitResponse.onResponse(null)
                        val code = response.code()
                        if (code == 403) {

                        } else if (code == 400 || code == 401 || code == 422 || code == 500) {

                        }

                    }

                }


                override fun onFailure(call: Call<String>?, t: Throwable?) {
                    call!!.cancel()
                    if (showProgress && finalDialog != null)
                        if (finalDialog.isShowing) {
                            AppUtils.hideProgress(finalDialog)
                        }

                    retrofitResponse.onResponse(null)
                    val message = t!!.message
                    if (message != null && !message.isEmpty() && !message.equals(
                            "null",
                            ignoreCase = true
                        )
                    ) {
                        Log.e("RetrofitException", t.message + "")
                        if (!message.contains("not found: limit=1 content="))
                            AppUtils.showToast(activity, message + "", true)
                    } else {
                        Log.e("RetrofitException", t.toString() + "")
                        if (!activity.isFinishing)
                            AppUtils.showToast(
                                activity,
                                activity.getString(R.string.server_error),
                                true
                            )
                    }
                    if (t.message != null) {
                        Log.e("RetrofitException", t.message!!)
                        AppUtils.showToast(activity, t.message!!, true)
                    }

                }
            })
            return true
        }
    }


}





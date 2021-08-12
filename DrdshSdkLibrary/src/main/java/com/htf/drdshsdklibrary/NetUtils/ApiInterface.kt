package com.htf.drdshsdklibrary.NetUtils

import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @FormUrlEncoded
    @POST("validate-identity")
    fun validateIdentity(
        @Field("appSid")appSid:String,
        @Field("locale")locale:String,
        @Field("expandWidth")expandWidth:String,
        @Field("expendHeight")expendHeight:String,
        @Field("deviceID")deviceID:String,
        @Field("ipAddress")ipAddress:String,
        @Field("browser")browser:String,
        @Field("domain")domain:String,
        @Field("name")name:String?,
        @Field("email")email:String?,
        @Field("mobile")mobile:String?,
        @Field("fullUrl")fullUrl:String?,
        @Field("metaTitle")metaTitle:String?,
        @Field("resolution")resolution:String?,
        @Field("visitorID")visitorID:String?,
        @Field("localIp")localIp:String?,
        @Field("availableScreenResolution")availableScreenResolution:String?,
        @Field("timeZone")timeZone:String?,
        @Field("timeZoneOffset")timeZoneOffset:String?,
        @Field("device")device:String?
        ):Call<String>

}
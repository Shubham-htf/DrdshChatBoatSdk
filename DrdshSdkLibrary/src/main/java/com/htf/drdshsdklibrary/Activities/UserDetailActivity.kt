package com.htf.drdshsdklibrary.Activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.PowerManager
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.github.nkzawa.emitter.Emitter
import com.github.nkzawa.socketio.client.Ack
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.htf.drdshsdklibrary.Models.AgentAcceptChat
import com.htf.drdshsdklibrary.Models.JoinChatRoom
import com.htf.drdshsdklibrary.Models.VerifyIdentity
import com.htf.drdshsdklibrary.NetUtils.APIClient
import com.htf.drdshsdklibrary.NetUtils.RetrofitResponse
import com.htf.drdshsdklibrary.R
import com.htf.drdshsdklibrary.Utills.AppUtils
import com.htf.drdshsdklibrary.Utills.Constants
import com.htf.drdshsdklibrary.Utills.Constants.ACTION_AGENT_ACCEPT_CHAT_REQUEST
import com.htf.drdshsdklibrary.Utills.Constants.IS_AGENT_OFFLINE
import com.htf.drdshsdklibrary.Utills.Constants.IS_AGENT_ONLINE
import com.htf.drdshsdklibrary.Utills.LocalizeActivity
import com.htf.drdshsdklibrary.Utills.RegExp
import com.htf.learnchinese.utils.AppPreferences
import com.htf.learnchinese.utils.AppSession
import com.htf.learnchinese.utils.AppSession.Companion.mSocket
import kotlinx.android.synthetic.main.activity_user_detail.*
import kotlinx.android.synthetic.main.toolbar.*
import org.json.JSONException
import org.json.JSONObject


class UserDetailActivity : LocalizeActivity(), View.OnClickListener {

    private val currActivity:Activity=this
    private var appSid=""
    private var locale=""
    private var domain=""
    private var displayMetrics=DisplayMetrics()
    private var deviceId=""
    var mWakeLock: PowerManager.WakeLock? = null

    private var strName=""
    private var strEmail=""
    private var strMobile=""
    private var strMsg=""

    private var name:String?=null
    private var email:String?=null
    private var mobile:String?=null
    private var vistorId:String?=null


    companion object{
        fun open(currActivity: Activity,
                 appSid:String,
                 locale:String,
                 deviceID:String,
                 domain:String
        ){
            val intent= Intent(currActivity,UserDetailActivity::class.java)
            intent.putExtra("appSid",appSid)
            intent.putExtra("locale",locale)
            intent.putExtra("deviceId",deviceID)
            intent.putExtra("domain",domain)
            currActivity.startActivity(intent)
        }
    }

    @SuppressLint("HardwareIds", "InvalidWakeLockTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        setListener()
        getExtra()
        tvCloseChat.visibility=View.VISIBLE
        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag")
        this.mWakeLock!!.acquire(10*60*1000L /*10 minutes*/)
        displayMetrics=AppUtils.getDisplayMatrix(currActivity)
        socketConnecting()

    }

    private fun getExtra() {
        appSid=intent.getStringExtra("appSid")!!
        locale=intent.getStringExtra("locale")!!
        domain=intent.getStringExtra("domain")!!
        deviceId=intent.getStringExtra("deviceId")!!
        AppSession.appSid=appSid
        callVerifyIdentity()
    }

    private fun setListener() {
        iv_back_pressed.setOnClickListener(this)
        btnStartChat.setOnClickListener(this)
        iv_back_pressed.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnStartChat->{
                if(checkOnlineValidation()){
                    val joinChatRoom=AppPreferences.getInstance(currActivity).getJoinChatRoomDetails()
                    joinChatRoom?.name=strName
                    joinChatRoom?.email=strEmail
                    joinChatRoom?.mobile=strMobile
                    joinChatRoom?.message=strMsg
                    AppPreferences.getInstance(currActivity).saveJoinChatRoomDetails(joinChatRoom!!)

                    startChat()
                }
            }
            R.id.iv_back_pressed->{
                currActivity.finish()
            }
        }
    }

    private fun callVerifyIdentity(){
        val joinChatRoom=AppPreferences.getInstance(currActivity).getJoinChatRoomDetails()
        if (joinChatRoom!=null){
            name=joinChatRoom.name
            email=joinChatRoom.email
            mobile=joinChatRoom.mobile
        }
        val verifyIdentity=AppPreferences.getInstance(currActivity).getIdentityDetails()
        if (verifyIdentity!=null){
            vistorId=verifyIdentity.visitorID
        }

        val call =APIClient.getClient().validateIdentity(
            appSid,locale,
            displayMetrics.widthPixels.toString(),
            displayMetrics.heightPixels.toString(),
            deviceId,
            AppUtils.getIPAddress(true)!!,
            "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:73.0)",
            domain,
            name,
            email,
            mobile,
            "Contact-Us",
            "Contact-Us",
            "${displayMetrics.widthPixels}x${displayMetrics.heightPixels}",
            vistorId,
            AppUtils.getIPAddress(true),
            "${displayMetrics.widthPixels}x${displayMetrics.heightPixels}",
            AppUtils.getTimeZone().id,
            null,
            AppSession.deviceType

        )

        APIClient.getResponse(call,currActivity,null,true,object :RetrofitResponse{
            override fun onResponse(response: String?) {
                try {
                    if (response!=null){
                        ll_main.visibility=View.VISIBLE
                        val jsonObject=JSONObject(response)
                        val data=jsonObject.optJSONObject("data")
                        if (data!=null){
                            val type=object :TypeToken<VerifyIdentity>(){}.type
                            val verifyIdentity=Gson().fromJson<VerifyIdentity>(data.toString(),type)
                            AppPreferences.getInstance(currActivity).saveIdentityDetails(verifyIdentity)
                            setData(verifyIdentity)
                            Log.d("verifyIdentity",verifyIdentity.toString())
                        }
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }

        })
    }

    private fun socketConnecting(){
        try {
            if(mSocket==null){
                mSocket = IO.socket("https://www.drdsh.live/")
                mSocket!!.io().reconnection(false)
            }
            if (mSocket != null) {
                if (!mSocket!!.connected()) {
                    mSocket!!.on(Socket.EVENT_CONNECT, onConnected)
                    mSocket!!.on("disconnect",onDisconnect)
                    mSocket!!.connect()
                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }

    }


    private var inviteVisitorListener: Emitter.Listener = Emitter.Listener { args ->
        try {
            val data = if (args.isNotEmpty()) args[0]?.toString() else null
            currActivity.runOnUiThread {
                if (data != null) {
                    val type=object :TypeToken<JoinChatRoom>(){}.type
                    val joinChatRoom=Gson().fromJson<JoinChatRoom>(data.toString(),type)
                    AppPreferences.getInstance(currActivity).saveJoinChatRoomDetails(joinChatRoom)
                    ChatActivity.open(currActivity)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }



    private fun joinVisitorsRoom() {
        val verifyIdentity = AppPreferences.getInstance(currActivity).getIdentityDetails()
        if (verifyIdentity != null) {
            val userJson = JSONObject()
            userJson.put("dc_vid", verifyIdentity.visitorID)
            userJson.put("appSid",appSid)
            userJson.put("device",AppSession.deviceType)
            mSocket!!.emit("joinVisitorsRoom", userJson, Ack { args ->
                val data = if (args.isNotEmpty()) args[0]?.toString() else null
                if (data != null) {
                    runOnUiThread {
                        try {
                            Log.d("Socket Agent ID ",data)
                            val type=object :TypeToken<JoinChatRoom>(){}.type
                            val joinChatRoom=Gson().fromJson<JoinChatRoom>(data.toString(),type)
                            AppPreferences.getInstance(currActivity).saveJoinChatRoomDetails(joinChatRoom)
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                }
            })
        }
    }

    private fun startChat(){
        if (!mSocket!!.connected()) {
            mSocket!!.connect()
        }
        val verifyIdentity = AppPreferences.getInstance(currActivity).getIdentityDetails()
        if (verifyIdentity != null) {
            val userJson = JSONObject()
            userJson.put("_id", verifyIdentity.visitorID)
            userJson.put("name",strName)
            userJson.put("email",strEmail)
            userJson.put("mobile",strMobile)
            userJson.put("message",strMsg)
            userJson.put("appSid",appSid)
            userJson.put("device",AppSession.deviceType)
            mSocket!!.emit("inviteChat", userJson, Ack { args ->
                val data = if (args.isNotEmpty()) args[0]?.toString() else null
                runOnUiThread {
                    if (data != null) {
                        try {
                            Log.d("inviteChat",data)
                            etFullName.setText("")
                            etEmail.setText("")
                            etMobile.setText("")
                            etQuestion.setText("")
                            ChatActivity.open(currActivity)
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                }
            })
        }

    }


    private fun setData(verifyIdentity: VerifyIdentity?) {

        when(verifyIdentity?.visitorConnectedStatus){
            Constants.CHAT_IN_NORMAL_MODE->{
                when(verifyIdentity.agentOnline){
                    IS_AGENT_ONLINE->{
                        btnStartChat.text=getString(R.string.start_chat)
                    }
                    IS_AGENT_OFFLINE->{
                        btnStartChat.text=getString(R.string.drop_a_message)
                    }
                }
            }
            Constants.CHAT_IN_WAITING_MODE->{
                ChatActivity.open(currActivity)
            }

            Constants.CHAT_IN_CONNECTED_MODE->{
                ChatActivity.open(currActivity)
            }
        }

        /* here is the option for email and number dynamic show
        * */

        if (verifyIdentity!!.embeddedChat!!.emailRequired==0){
                etEmail.visibility=View.GONE
            } else{
                etEmail.visibility=View.VISIBLE
           }

        if(verifyIdentity.embeddedChat!!.mobileRequired==0){
            etMobile.visibility=View.GONE
          }else{
            etMobile.visibility=View.VISIBLE
           }


        rlt_top_bar.setBackgroundColor(Color.parseColor(verifyIdentity.embeddedChat?.topBarBgColor))
        btnStartChat.backgroundTintList = ColorStateList.valueOf(Color.parseColor(verifyIdentity.embeddedChat?.buttonColor))

    }

    private fun checkOnlineValidation():Boolean{
        var isValid=true
        strName=etFullName.text.toString().trim()
        strEmail=etEmail.text.toString().trim()
        strMobile=etMobile.text.toString().trim()
        strMsg=etQuestion.text.toString().trim()

        when{
            RegExp.chkEmpty(strName)->{
                isValid=false
                AppUtils.showSnackBar(currActivity,tvError,getString(R.string.name_required))
            }
            RegExp.chkEmpty(strEmail)->{
                isValid=false
                AppUtils.showSnackBar(currActivity,tvError,getString(R.string.email_required))
            }
            !RegExp.isValidEmail(strEmail)->{
                isValid=false
                AppUtils.showSnackBar(currActivity,tvError,getString(R.string.email_invalid))
            }
            RegExp.chkEmpty(strMobile)->{
                isValid=false
                AppUtils.showSnackBar(currActivity,tvError,getString(R.string.mobile_required))
            }
            !RegExp.isValidPhone(strMobile)->{
                isValid=false
                AppUtils.showSnackBar(currActivity,tvError,getString(R.string.mobile_invalid))
            }
            RegExp.chkEmpty(strMsg)->{
                isValid=false
                AppUtils.showSnackBar(currActivity,tvError,getString(R.string.message_required))
            }
            else->{
                tvError.visibility=View.GONE
            }
        }
        return isValid
    }

    private var agentAcceptedChatRequest: Emitter.Listener = Emitter.Listener { args ->
        try {
            val data = if (args.isNotEmpty()) args[0]?.toString() else null
            currActivity.runOnUiThread {
                if (data != null) {
                    Log.e("agentAcceptedChat", data)
                    val type=object :TypeToken<AgentAcceptChat>(){}.type
                    val agentAcceptChat=Gson().fromJson<AgentAcceptChat>(data,type)
                    val intent= Intent(ACTION_AGENT_ACCEPT_CHAT_REQUEST)
                    intent.putExtra("agentAcceptedChat",agentAcceptChat)
                    LocalBroadcastManager.getInstance(currActivity).sendBroadcast(intent)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }



    private var onConnected: Emitter.Listener = Emitter.Listener{ args ->

    }

    private var onDisconnect: Emitter.Listener= Emitter.Listener { args ->
        try {
            val data = if (args.isNotEmpty()) args[0]?.toString() else null
            runOnUiThread {
                if (data != null) {
                    Log.e("onDisconnect", data)
                    if (mSocket != null) {
                        if (!mSocket!!.connected()) {
                            mSocket!!.on(Socket.EVENT_CONNECT, onConnected)
                            mSocket!!.connect()
                            joinVisitorsRoom()
                        }
                    }


                }
            }

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

    }

    override fun onResume() {
        super.onResume()
        joinVisitorsRoom()
        mSocket!!.on("inviteVisitorListener", inviteVisitorListener)

    }

}
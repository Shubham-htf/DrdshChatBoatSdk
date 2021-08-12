package com.htf.drdshsdklibrary.Adapter

import ImageFullView
import android.app.Activity
import android.content.Context
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.htf.drdshsdklibrary.Activities.ChatActivity
import com.htf.drdshsdklibrary.Models.Message
import com.htf.drdshsdklibrary.PhotoViewer.PhotoFullPopupWindow
import com.htf.drdshsdklibrary.R
import com.htf.drdshsdklibrary.Utills.AppUtils
import com.htf.drdshsdklibrary.Utills.Constants
import com.htf.drdshsdklibrary.Utills.Constants.ATTACHMENT_URL

import com.htf.learnchinese.utils.AppPreferences
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_incoming_msg.view.*
import kotlinx.android.synthetic.main.row_info_msg.view.*
import kotlinx.android.synthetic.main.row_outgoing_msg.view.*
import java.io.File
import kotlin.collections.ArrayList

class ChatAdapter(private val currActivity:Activity,
                  private val arrMessage:ArrayList<Message>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_MESSAGE_SENT=1
    private val VIEW_TYPE_MESSAGE_RECEIVED=2
    private val VIEW_TYPE_INFO_MESSAGE=3


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder = when (viewType) {
            VIEW_TYPE_MESSAGE_SENT -> SentViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.row_outgoing_msg,
                    parent,
                    false
                )
            )
            VIEW_TYPE_MESSAGE_RECEIVED-> ReceivedViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.row_incoming_msg,
                    parent,
                    false
                )
            )
            VIEW_TYPE_INFO_MESSAGE-> InfoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.row_info_msg,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException()

        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return arrMessage.size
    }


    /* set the view type here*/

    override fun getItemViewType(position: Int): Int {
        val user= AppPreferences.getInstance(currActivity).getIdentityDetails()
        val message=arrMessage[position]

        val viewType=if(message.isSystem!!){
            VIEW_TYPE_INFO_MESSAGE
        }else{
            when{
                (message.sendBy==Constants.FROM_AGENT)->{
                    VIEW_TYPE_MESSAGE_RECEIVED
                }
                else->{
                    VIEW_TYPE_MESSAGE_SENT
                }
            }
        }
        return viewType


    }

    /* Bind the view in View Holder*/

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType=holder.itemViewType
        val model=arrMessage[position]
        when(viewType){
            VIEW_TYPE_MESSAGE_SENT->{
                holder as SentViewHolder

                holder.itemView.tvOutgoingMsgTime.text=AppUtils.convertDateFormat(model.createdAt,
                    AppUtils.serverChatUTCDateTimeFormat,
                    AppUtils.targetTimeFormat)


                holder.itemView.ivOutgoingMsg.setOnClickListener {
                        if (model.isLocal){
                            PhotoFullPopupWindow(holder.itemView,model.tempFile!!,currActivity)
                        } else{
                            ImageFullView(holder.itemView,ATTACHMENT_URL+ model.attachmentFile!!,currActivity)
                        }
                }

                when(model.isAttachment){
                    Constants.ATTACHMENT_MESSAGE->{
                        holder.itemView.tvOutgoingMsg.visibility=View.GONE
                        holder.itemView.ivOutgoingMsg.visibility=View .VISIBLE
                        if (model.isLocal){
                            Picasso.get().load(model.tempFile!!).placeholder(R.drawable.image_placeholder).into(holder.itemView.ivOutgoingMsg)
                        }else{
                            model.tempFile=getTempFile(currActivity,model.message!!)
                            Picasso.get().load(ATTACHMENT_URL+  model.attachmentFile).placeholder(R.drawable.image_placeholder).into(holder.itemView.ivOutgoingMsg)
                        }
                    }
                    Constants.NORMAL_MESSAGE->{
                        holder.itemView.tvOutgoingMsg.visibility=View.VISIBLE
                        holder.itemView.ivOutgoingMsg.visibility=View.GONE
                        holder.itemView.tvOutgoingMsg.text=model.message
                    }
                }


                when {
                    model.readAt != null -> {
                        holder.itemView.ivSent.setImageResource(R.drawable.ic_delivered)
                    }
                    model.deliveredAt != null -> {
                        holder.itemView.ivSent.setImageResource(R.drawable.ic_seen)
                    }
                    else -> {
                        holder.itemView.ivSent.setImageResource(R.drawable.ic_tick)
                    }
                }
            }

            VIEW_TYPE_MESSAGE_RECEIVED->{
                holder as ReceivedViewHolder
                Picasso.get().load(Constants.AGENT_IMAGE_URL+model.agentId?.image).placeholder(R.drawable.user).into(holder.itemView.ivAgent)
                holder.itemView.tvIncomingMsgTime.text=AppUtils.convertDateFormat(model.createdAt,
                    AppUtils.serverChatUTCDateTimeFormat,
                    AppUtils.targetTimeFormat)
                holder.itemView.tvAgentName.text=model.agentId?.name!!

                when(model.isAttachment){
                    Constants.ATTACHMENT_MESSAGE->{
                        holder.itemView.tvIncomingMsg.visibility=View.GONE
                        if (model.fileType?.contains(Constants.IMAGE)!!){
                            holder.itemView.rlIncomingImage.visibility=View.VISIBLE
                            if (model.attachmentFile?.isFileDownloaded(currActivity)!!){
                                holder.itemView.rlIncomingImageTransparent.visibility=View.GONE
                                model.tempFile=getTempFile(currActivity,model.attachmentFile!!)
                                Picasso.get().load(model.tempFile!!).into(holder.itemView.ivIncomingImage)
                            }else{
                                holder.itemView.rlIncomingImageTransparent.visibility=View.VISIBLE
                                Picasso.get().load(ATTACHMENT_URL+model.attachmentFile).placeholder(R.drawable.image_placeholder).into(holder.itemView.ivIncomingImage)
                            }
                        }
                    }

                    Constants.NORMAL_MESSAGE->{
                        holder.itemView.tvIncomingMsg.visibility=View.VISIBLE
                        holder.itemView.rlIncomingImage.visibility=View.GONE
                        holder.itemView.tvIncomingMsg.text=model.message
                    }
                }

                holder.itemView.ivIncomingImage.setOnClickListener {
                    if (model.attachmentFile?.isFileDownloaded(currActivity)!!){
                        PhotoFullPopupWindow(holder.itemView, model.tempFile!!, currActivity)
                    }
                }

                holder.itemView.ivIncomingImageDownload.setOnClickListener {
                    try {
                        (currActivity as ChatActivity).downloadImageFile(
                            currActivity,ATTACHMENT_URL+model.attachmentFile,
                            model.attachmentFile!!, holder)
                    } catch(ex:Exception){

                    }
                }
            }
            VIEW_TYPE_INFO_MESSAGE->{
                holder as InfoViewHolder
                when {
                    model.messageInfoTypeShowLoading -> {
                        holder.itemView.tvInfoMsg.text=model.message
                        (currActivity as ChatActivity).showResendOption(holder,position)
                    }
                    else -> {
                        holder.itemView.pbWaiting.visibility=View.GONE
                        holder.itemView.tvInfoMsg.text=model.message
                    }
                }
            }

        }
    }


    /* There is no use of this Holder*/

    class SentViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    class ReceivedViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    class InfoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }


    /* Download Image And File*/

    private fun String.isFileDownloaded(context: Context):Boolean{

        val tempFile = File(
            Environment.getExternalStorageDirectory().absolutePath+"/Drdsh/Media/",
            this
        )
        Log.e("FILE PATH", "File Path:$tempFile")
        return tempFile.exists()
    }

    private fun getTempFile(context: Context,name:String):File{
        val tempFile = File(
            Environment.getExternalStorageDirectory().absolutePath+"/Drdsh/Media/",
            name
        )
        Log.e("FILE PATH", "File Path:$tempFile")
        return tempFile
    }



}
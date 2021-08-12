package com.htf.drdshsdklibrary.Utills

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.ProgressBar
import com.htf.drdshsdklibrary.PhotoViewer.TouchImageView
import com.htf.drdshsdklibrary.R
import com.squareup.picasso.Picasso

class ImageFullView (rootView: View, imageUrl: String) :
    PopupWindow(
        (MyApplication.getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
            R.layout.popup_photo_full,
            null
        ), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
    ) {
    private val view: View
    private var imageView: TouchImageView
    private var loading: ProgressBar
    internal var parent: ViewGroup

    init {
        if (Build.VERSION.SDK_INT >= 21) {
            elevation = 5.0f
        }
        this.view = contentView
        val closeButton = this.view.findViewById(R.id.ib_close) as ImageButton
        isOutsideTouchable = true
        isFocusable = true

        imageView = view.findViewById(R.id.image) as TouchImageView
        loading = view.findViewById(R.id.loading) as ProgressBar
        parent = imageView.parent as ViewGroup
        //loading.visibility = View.VISIBLE

        closeButton.setOnClickListener {
            dismiss()
        }

        Picasso.get().load(imageUrl).placeholder(R.drawable.image_placeholder).into(imageView)

        /* Glide.with(MyApplication.instance).load(imageUrl).placeholder(R.drawable.placeholder_rect)
             .listener(object : RequestListener<Drawable> {
                 override fun onLoadFailed(
                     e: GlideException?,
                     model: Any?,
                     target: Target<Drawable>?,
                     isFirstResource: Boolean
                 ): Boolean {
                     loading.visibility = View.VISIBLE
                     return false
                 }

                 override fun onResourceReady(
                     resource: Drawable?,
                     model: Any?,
                     target: Target<Drawable>?,
                     dataSource: DataSource?,
                     isFirstResource: Boolean
                 ): Boolean {
                     loading.visibility = View.GONE
                     return false
                 }


             })
             .into(imageView)*/
        showAtLocation(rootView, Gravity.CENTER, 0, 0)

    }

}


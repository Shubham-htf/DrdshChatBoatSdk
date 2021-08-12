package com.htf.drdshsdklibrary.Activities

import android.Manifest.permission.CAMERA
import android.content.Context
import android.graphics.Bitmap
import android.hardware.Camera
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.htf.drdshsdklibrary.R
import kotlinx.android.synthetic.main.activity_camera.*


class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

    }


}
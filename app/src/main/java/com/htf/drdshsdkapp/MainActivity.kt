package com.htf.drdshsdkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.htf.drdshsdklibrary.Activities.ChatActivity
import com.htf.drdshsdklibrary.Activities.UserDetailActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val deviceId = Settings.Secure.getString(
            this.contentResolver,
            Settings.Secure.ANDROID_ID)!!

        /* Old appS Id :: 5def86cf64be6d13f55f2034.5d96941bb5507599887b9c71829d5cffcdf55014*/

        UserDetailActivity.open(this, "5def872764be6d13f55f203e.d3a138e76865367612af2c306bb38c1ce205939b", "en",
            deviceId,
        "drdsh.live")
    }
}

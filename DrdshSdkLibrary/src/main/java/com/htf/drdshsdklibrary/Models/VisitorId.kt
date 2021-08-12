package com.htf.drdshsdklibrary.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class VisitorId:Serializable {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("_id")
    @Expose
    var id: String? = null
}
package com.playlab.instaland.model

import com.google.gson.annotations.SerializedName

open class DisplayResources (
    @SerializedName("src")
    val src: String,
    @SerializedName("config_width")
    val configWidth: Int,
    @SerializedName("config_height")
    val configHeight: Int
        )
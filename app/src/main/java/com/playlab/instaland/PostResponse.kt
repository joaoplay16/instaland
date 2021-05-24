package com.playlab.instaland

import com.google.gson.annotations.SerializedName
import com.playlab.instaland.model.Media

data class PostResponse (
    @SerializedName("shortcode_media")
    val shortCodeMedia:Media
    )
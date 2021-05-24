package com.playlab.instaland.model

import com.google.gson.annotations.SerializedName

class Graphql (
    @SerializedName("shortcode_media")
    val shortCodeMedia: Media) {

    operator fun component1(): Media {
        return shortCodeMedia
    }
}
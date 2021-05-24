package com.playlab.instaland.model

import com.google.gson.annotations.SerializedName

open class Media (

    @SerializedName("__typename")
    open var typeName: String,
    @SerializedName("id")
    open var id: String,
    @SerializedName("shortcode")
    open var shortCode: String,
    @SerializedName("display_url")
    open var displayUrl: String,
    @SerializedName("is_video")
    open var isVideo: Boolean,
    @SerializedName("display_resources")
    open var displayResources: List<DisplayResources> = ArrayList(),
    @SerializedName("edge_sidecar_to_children")
    open var edgeSidecar: EdgeSidecar) {

}
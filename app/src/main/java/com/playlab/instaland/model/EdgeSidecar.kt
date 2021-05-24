package com.playlab.instaland.model

import com.google.gson.annotations.SerializedName

data class EdgeSidecar (
    @SerializedName("edges")
    val edges : List<Edge>
        ){

    data class Edge(
        @SerializedName("node")
        val node : Node
    )

    data class Node(
        @SerializedName("__typename")
        var typeName: String,
        @SerializedName("id")
        var id: String,
        @SerializedName("shortcode")
        var shortCode: String,
        @SerializedName("display_url")
        var displayUrl: String,
        @SerializedName("display_resources")
        var displayResources: List<DisplayResources>,
        @SerializedName("is_video")
        var isVideo: Boolean
    )
}


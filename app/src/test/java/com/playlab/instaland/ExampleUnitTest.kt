package com.playlab.instaland

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun isGraphVideo() {
        val http = HttpJson()
        val obj = http.parse("https://www.instagram.com/p/CPOEkRCHipT/?utm_source=ig_web_copy_link&__a=1")
        val  (shortCodeMedia) = obj!!.graphql

        assertEquals("GraphVideo", shortCodeMedia.typeName)
        assertEquals(true, shortCodeMedia.isVideo)
//        println(obj.graphql.shortCodeMedia.typeName)
//        println(obj.graphql.shortCodeMedia.id)
//        println(obj.graphql.shortCodeMedia.displayUrl)
//        println(obj.graphql.shortCodeMedia.shortCode)
//        println(obj.graphql.shortCodeMedia.displayResources.map{Pair(it.configWidth, it.configHeight )})
    }
    @Test
    fun isGraphSidecar() {
        val http = HttpJson()
        val obj = http.parse("https://www.instagram.com/p/CPNq_PLrD8N/?utm_source=ig_web_copy_link&__a=1")
        assertEquals("GraphSidecar", obj!!.graphql.shortCodeMedia.typeName)
        println(obj.graphql.shortCodeMedia.typeName)
        println(obj.graphql.shortCodeMedia.id)
        println(obj.graphql.shortCodeMedia.displayUrl)
        println(obj.graphql.shortCodeMedia.shortCode)
        println(obj.graphql.shortCodeMedia.displayResources.map{Pair(it.configWidth, it.configHeight )})
        println(obj.graphql.shortCodeMedia.edgeSidecar.edges.map { it.node.displayResources.first().configWidth })

    }

    @Test
    fun isGraphImage() {
        val http = HttpJson()
        val obj = http.parse("https://www.instagram.com/p/CPLqA_8s-5E/?utm_source=ig_web_copy_link&__a=1")
        assertEquals("GraphImage", obj!!.graphql.shortCodeMedia.typeName)
        println(obj.graphql.shortCodeMedia.typeName)
        println(obj.graphql.shortCodeMedia.id)
        println(obj.graphql.shortCodeMedia.displayUrl)
        println(obj.graphql.shortCodeMedia.shortCode)
        println(obj.graphql.shortCodeMedia.displayResources.map{Pair(it.configWidth, it.configHeight )})
        println(obj.graphql.shortCodeMedia.edgeSidecar != null)

    }
}
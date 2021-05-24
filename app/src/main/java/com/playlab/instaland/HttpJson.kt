package com.playlab.instaland

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.Gson
import com.playlab.instaland.model.Graphql
import com.playlab.instaland.model.Main
import com.playlab.instaland.model.Media
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import java.nio.charset.MalformedInputException

class HttpJson {
    @Throws(IOException::class, MalformedInputException::class)
    private fun connect(baseUrl: String): HttpURLConnection {
        val seconds = 1000
        val url = URL(baseUrl)
        val conexao = url.openConnection() as HttpURLConnection
        conexao.readTimeout = 10 * seconds
        conexao.connectTimeout = 15 * seconds
        conexao.requestMethod = "GET"
        conexao.doInput = true
        conexao.doOutput = false
        conexao.connect()
        return conexao
    }
    public fun parse(baseUrl: String): Main? {
        try {
            val conexao: HttpURLConnection =
                connect(baseUrl)
            val resposta = conexao.responseCode
            if (resposta == HttpURLConnection.HTTP_OK) {
                val `is` = conexao.inputStream
                val json =  bytesToString(`is`)
                return Gson().fromJson(json, Main::class.java)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    @Throws(IOException::class)
    private fun bytesToString(`is`: InputStream): String {
        val buffer = ByteArray(1024)
        val bufferzao = ByteArrayOutputStream()
        var bytesLidos: Int
        while (`is`.read(buffer).also{ bytesLidos = it } != -1) {
            bufferzao.write(buffer, 0, bytesLidos)
        }
        return String(bufferzao.toByteArray(), Charset.forName("UTF-8"))
    }

    fun hasConnection(ctx: Context): Boolean {
        val cm = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = cm.activeNetworkInfo
        return info != null && info.isConnected
    }
}
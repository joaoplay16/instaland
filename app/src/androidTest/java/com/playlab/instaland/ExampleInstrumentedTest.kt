package com.playlab.instaland

import android.content.Context
import android.net.ConnectivityManager
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import com.playlab.instaland.model.Media
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import java.nio.charset.MalformedInputException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        try {
            val conexao: HttpURLConnection =
                connect("https://www.instagram.com/p/CPLiIoDF-S0/?__a=1")
            val resposta = conexao.responseCode
            if (resposta == HttpURLConnection.HTTP_OK) {
                val `is` = conexao.inputStream
                val json = JSONObject(bytesToString(`is`))

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

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

    private fun parse(json: String){
        val mediaObject = Gson().fromJson<Media>(json, Media::class.java)
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
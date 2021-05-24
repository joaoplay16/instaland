package com.playlab.instaland

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.playlab.instaland.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            getCurrentData()
            Log.d("SNEADTGRE", "click")

        }

    }

    fun getCurrentData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.instagram.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PostService::class.java)
        service.getPostData(1)
            ?.enqueue(object: Callback<PostResponse?> {
                override fun onResponse(
                    call: Call<PostResponse?>,
                    response: Response<PostResponse?>
                ) {
                    Log.d("SNEADTGRE", response.code().toString())
                    Log.d("SNEADTGRE", response.raw().request().url().toString())
                    if (response.code() == 200){
                        val postResponse: PostResponse = response.body()!!
                        val stringBuilder = """
                            Type: ${postResponse.shortCodeMedia.typeName}
                        """.trimIndent()
                        Log.d("SNEADTGRE", stringBuilder)
                    }
                }

                override fun onFailure(call: Call<PostResponse?>, t: Throwable) {
                    Log.e("SNEADTGRE",  t.message!!)
                }
            })
    }

}
package com.example.gabrielamazonas.devprofile

import okhttp3.*
import org.junit.Test

import org.junit.Assert.*
import java.io.IOException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        fun callApi(url: String) {
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call?, e: IOException?) {
                }

                override fun onResponse(call: Call?, response: Response) {
                    println(response.body()?.string())
                }
            })
        }

        callApi("https://api.github.com/users/GabrielAmazonas")
        assertEquals(4, 2 + 2)
    }
}

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

    }

    @Test
    fun testApiCall() {
        fun callApi(url: String): String? {
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()
            var result = ""
            fun populateResult(content: String) {
                result = content
            }
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call?, e: IOException?) {
                    result = ""
                }

                override fun onResponse(call: Call?, response: Response) {

                    result = (response.body()?.string()!!)
                    populateResult(result)
                }
            })

            return result
        }



        val result = callApi("https://api.github.com/users/octocat")
        assertEquals(false, result.isNullOrBlank())
    }
}

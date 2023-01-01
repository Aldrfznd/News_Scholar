package koding.aldi.data.remote

import retrofit2.Call
import retrofit2.http.GET
import koding.aldi.data.response.NewsResponse

interface ApiServices{

    @GET("top-headlines?country=id&apiKey=1f5b509cda0e4e0f9d45c03c05820fca")
    fun getNews() : Call <NewsResponse>
}
package koding.aldi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import koding.aldi.R
import koding.aldi.data.remote.ApiClient
import koding.aldi.data.response.ArticlesItem
import koding.aldi.data.response.NewsResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter= NewsAdapter {

        }
        rvNews.layoutManager = LinearLayoutManager(this)

        rvNews.adapter = NewsAdapter {

        }
    }

    private fun getNews() {
        ApiClient.create().getNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val articles: List<ArticlesItem> =
                        response.body()?.articles as List<ArticlesItem>
                        adapter.setNews(articles)
                }
            }


            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

            }

        })
    }
}
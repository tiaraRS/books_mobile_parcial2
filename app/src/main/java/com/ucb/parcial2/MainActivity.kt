package com.ucb.parcial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //RETROFIT
        val restApiAdapter = RestApiAdapter()
        val endPoint = restApiAdapter.connectionApi()
        val bookResponseCall = endPoint.getAllPost()
        val listPosts = arrayListOf<Post>();
        bookResponseCall.enqueue( object : Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response?.body()
                Log.d("RESP POST", Gson().toJson(posts))
                posts?.forEach {
                    Log.d("RESP TITLE", it.title)
                    Log.d("RESP POST", it.body)
                    listPosts.add(Post(it.title,it.body))
                }
                Log.d("listPosts IN", listPosts.size.toString())
                setUpRecyclerView(listPosts)

            }
        })

       /* Log.d("listPosts", listPosts.size.toString())
        Log.d("hola","chau")
        //RECYCLER VIEW
        val listPosts2= arrayListOf<Post>(
            Post("title1", "body1"),
            Post("title2", "body2"),
            Post("title3", "body3")
        )
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = PostListAdapter(listPosts, this)*/
    }
    fun setUpRecyclerView(listPosts: ArrayList<Post>){
        Log.d("listPosts OUT", listPosts.size.toString())
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = PostListAdapter(listPosts, MainActivity())
    }
}
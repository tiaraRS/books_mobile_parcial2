package com.ucb.parcial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit()
        GlobalScope.launch {
            val postDao = AppRoomDatabase.getDatabase(applicationContext).postDato()
            val repository = PostRepository(postDao)
            repository.insert(PostEntity("the best seller: Android","this is descirption"))
            val lista = repository.getListPosts()
            lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}, Body: ${it.description}")
            }
        }

    }
    suspend fun createDB(listPosts: ArrayList<Post>){
        val postDao = AppRoomDatabase.getDatabase(applicationContext).postDato()
        val repository = PostRepository(postDao)
        repository.insert(PostEntity("the best seller: Android", "this is descirption"))
        val lista = repository.getListPosts()
        lista.forEach {
            Log.d("DBTEST", "Id book = ${it.id}, Title: ${it.title}, Body: ${it.description}")
        }
    }
    fun retrofit(){
        //RETROFIT
        val restApiAdapter = RestApiAdapter()
        val endPoint = restApiAdapter.connectionApi()
        val postResponseCall = endPoint.getAllPost()
        val listPosts = arrayListOf<Post>();
        postResponseCall.enqueue( object : Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response?.body()
                Log.d("RESP POST", Gson().toJson(posts))
                posts?.forEach {
                    Log.d("RESP TITLE", it.title)
                    Log.d("RESP POST", it.body)
                    listPosts.add(Post(it.userId,it.id,it.title,it.body))
                }
                Log.d("listPosts IN", listPosts.size.toString())
                setUpRecyclerView(listPosts)
            }
        })
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
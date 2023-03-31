package com.ucb.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostViewActivity : AppCompatActivity() {
    lateinit var btnAdd: Button
    lateinit var title: EditText
    lateinit var description: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_view)
        btnAdd = findViewById(R.id.btn_add)
        title = findViewById(R.id.inp_title)
        description = findViewById(R.id.inp_description)
        btnAdd.setOnClickListener{
            GlobalScope.launch {
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)
                repository.insert(BookEntity(title.text.toString(),description.text.toString()))
                val lista = repository.getListBooks()
                lista.forEach {
                    Log.d(
                        "DBTEST",
                        "Id book = ${it.id}, Title: ${it.title}, Description: ${it.description}"
                    )
                }
            }
        }

    }

}
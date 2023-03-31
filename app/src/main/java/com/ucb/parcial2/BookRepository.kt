package com.ucb.parcial2

import IBookDao

class BookRepository(private val postDao: IBookDao) {

    suspend fun insert(post: BookEntity) {
        postDao.insert(post)
    }

    fun getListPosts(): List<BookEntity> {
        return postDao.getList()
    }
}

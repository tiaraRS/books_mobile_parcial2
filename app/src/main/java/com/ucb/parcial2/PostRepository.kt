package com.ucb.parcial2

import IPostDao

class PostRepository(private val postDao: IPostDao) {

    suspend fun insert(post: PostEntity) {
        postDao.insert(post)
    }

    fun getListPosts(): List<PostEntity> {
        return postDao.getList()
    }
}

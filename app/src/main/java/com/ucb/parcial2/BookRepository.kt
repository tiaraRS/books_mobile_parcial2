package com.ucb.parcial2

class BookRepository(private val bookDao: IBookDao) {

    suspend fun insert(book: BookEntity) {
        bookDao.insert(book)
    }

    fun getListBooks(): List<BookEntity> {
        return bookDao.getList()
    }
}

package com.ucb.parcial2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IBookDao {

    @Query("SELECT * FROM book")
    fun getList(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book:BookEntity)

    @Query("DELETE FROM book")
    suspend fun deleteAll()
}

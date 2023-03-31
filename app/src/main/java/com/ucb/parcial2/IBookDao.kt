import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ucb.parcial2.BookEntity

@Dao
interface IBookDao {

    @Query("SELECT * FROM book_table")
    fun getList(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(post: BookEntity)

    @Query("DELETE FROM book_table")
    suspend fun deleteAll()
}


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ucb.parcial2.Post
import com.ucb.parcial2.PostEntity

@Dao
interface IPostDao {

    @Query("SELECT * FROM post_table")
    fun getList(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(post:PostEntity)

    @Query("DELETE FROM post_table")
    suspend fun deleteAll()
}


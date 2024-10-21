package kz.app.assignment3.exercise9

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kz.app.assignment3.models.UserRoom

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: UserRoom)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserRoom>
}
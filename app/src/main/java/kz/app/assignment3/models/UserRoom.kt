package kz.app.assignment3.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserRoom(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val login: String
)

package kz.app.assignment3.exercise9

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// To send arguments into viewmodel
class UserViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDatabaseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserDatabaseViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
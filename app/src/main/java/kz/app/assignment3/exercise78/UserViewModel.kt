package kz.app.assignment3.exercise78

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.app.assignment3.models.User

class UserViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        _users.value = listOf(
            User(1, "Maksat", "MaskatMadeniyetov"),
            User(2, "Student1", "User1Login"),
            User(3, "Student2", "User2Login")
        )
    }

    fun addUser(user: User) {
        val currentList = _users.value ?: emptyList()
        _users.value = currentList + user
    }
}

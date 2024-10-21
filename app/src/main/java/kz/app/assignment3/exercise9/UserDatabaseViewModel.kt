package kz.app.assignment3.exercise9

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.app.assignment3.models.UserRoom

class UserDatabaseViewModel(private val userDao: UserDao) : ViewModel() {

    private val _users = MutableLiveData<List<UserRoom>>()
    val users: LiveData<List<UserRoom>> = _users

    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val userList = userDao.getAllUsers()
            _users.postValue(userList)
        }
    }

    fun insert(user: UserRoom) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.insert(user)
            val userList = userDao.getAllUsers()
            _users.postValue(userList)
        }
    }
}
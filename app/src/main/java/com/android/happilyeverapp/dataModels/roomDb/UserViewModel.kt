package com.android.happilyeverapp.dataModels.roomDb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val getUsers: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository =
                UserRepository(userDao)
        getUsers = repository.getUsers
    }

    fun signup(user: User) : Long {
        var id: Long = 0
        viewModelScope.launch(Dispatchers.IO) {
            id = repository.signup(user)
        }
        return id
    }

//    fun signup(user: User) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.signup(user)
//        }
//    }

    fun login(email: String, pwd: String): User {
        var user: User = User(0)
        val launch = viewModelScope.launch(Dispatchers.IO) {
            user = repository.login(email, pwd)
        }
        return user
    }

    fun getUser(id: Long): User {
        var user: User = User(0)
        val launch = viewModelScope.launch(Dispatchers.IO) {
            user = repository.getUser(id)
        }
        return user
    }

    fun updateProfile(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProfile(user)
        }
    }

    fun getUsers() : LiveData<List<User>>{
        var user: LiveData<List<User>> = MutableLiveData()
        viewModelScope.launch(Dispatchers.IO) {
            user = repository.getUsers()
        }
        return user
    }
}

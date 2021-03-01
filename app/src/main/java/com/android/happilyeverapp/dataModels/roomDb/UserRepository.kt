package com.android.happilyeverapp.dataModels.roomDb

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val getUsers: LiveData<List<User>> = userDao.getUsers()

    suspend fun signup(user: User) {
        userDao.signup(user)
    }

    suspend fun login(email: String, pwd: String): User {
        return userDao.login(email, pwd)
    }

    suspend fun getUser(email: String): User {
        return userDao.getUser(email)
    }

    suspend fun updateProfile(user: User) {
        userDao.updateProfile(user)
    }
}
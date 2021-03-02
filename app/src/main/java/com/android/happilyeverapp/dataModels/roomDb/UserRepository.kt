package com.android.happilyeverapp.dataModels.roomDb

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val getUsers: LiveData<List<User>> = userDao.getUsers()

    suspend fun signup(user: User) : Long{
        return userDao.signup(user)
    }

//    suspend fun signup(user: User){
//        userDao.signup(user)
//    }

    suspend fun login(email: String, pwd: String): User {
        return userDao.login(email, pwd)
    }

    suspend fun getUser(id: Long): User {
        return userDao.getUser(id)
    }

    suspend fun updateProfile(user: User) {
        userDao.updateProfile(user)
    }

    suspend fun getUsers(): LiveData<List<User>>{
        return userDao.getUsers()
    }
}

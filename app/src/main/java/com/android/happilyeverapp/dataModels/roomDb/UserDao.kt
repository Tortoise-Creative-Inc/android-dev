package com.android.happilyeverapp.dataModels.roomDb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun signup(vararg user: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun signup(user: User) : Long

    @Query("SELECT * FROM user_auth ORDER BY id ASC")
    fun getUsers() : LiveData<List<User>>

    @Query("SELECT * FROM user_auth WHERE email= :userEmail AND password= :userPwd")
    fun login(userEmail :String, userPwd :String) : User

    @Query("SELECT * FROM user_auth WHERE id= :id")
    fun getUser(id: Long) : User

    @Update
    fun updateProfile(user: User)

}

package com.android.happilyeverapp.dataModels.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {

            // returning existing db instance
            val temp =
                INSTANCE
            if(temp != null){
                return temp
            }

            // creating a db instance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_auth"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
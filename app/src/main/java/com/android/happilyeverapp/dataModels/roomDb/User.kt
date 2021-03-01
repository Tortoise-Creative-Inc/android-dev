package com.android.happilyeverapp.dataModels.roomDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_auth")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String? = null,
    var phno: String? = null,
    var email: String? = null,
    var password: String? = null,
    var age: Int? = 0,
    var location: String? = null,
    var religion: String? = null,
    var height: Float? = 0.0f,
    var education: String? = null,
    var maritalStatus: String? = null,
    var parents: String? = null,
    var brothers: Int? = 0,
    var sisters: Int? = 0
)
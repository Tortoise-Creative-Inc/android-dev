package com.android.happilyeverapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.happilyeverapp.R
import com.android.happilyeverapp.dataModels.roomDb.UserViewModel

class ProfileQuickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profilequick)

        var viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val email: String = intent.getStringExtra("email").toString()
        var user = viewModel.getUser(email)

        val name :TextView = findViewById(R.id.usersname)
        name.text = user.name

        val editText: EditText = findViewById(R.id.age)



        val btn_basic: Button = findViewById(R.id.btn_profile_basic)
        btn_basic.setOnClickListener {
            val intent: Intent = Intent(this, ProfileBasicActivity::class.java)
            startActivity(intent)
        }

        val btn_deep: Button = findViewById(R.id.btn_profile_deep)
        btn_deep.setOnClickListener {
            val intent: Intent = Intent(this, ProfileDeepActivity::class.java)
            startActivity(intent)
        }

        val logout: Button = findViewById(R.id.btn_logout)
        logout.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btn_submit: Button = findViewById(R.id.btn_submit_quick)
        btn_submit.setOnClickListener {
            user.age = R.id.age.toInt()
            user.location = R.id.location.toString()
            user.religion = R.id.religion.toString()
            user.height = R.id.height.toFloat()
            user.education = R.id.education.toString()
            user.maritalStatus = R.id.marital_status.toString()
            user.parents = R.id.parents.toString()
            user.brothers = R.id.brothers.toInt()
            user.sisters = R.id.sisters.toInt()

            var viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewModel.updateProfile(user)

            Toast.makeText(this, "Profile Updated", Toast.LENGTH_LONG).show()
        }
    }
}
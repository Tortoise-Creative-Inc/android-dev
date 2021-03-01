package com.android.happilyeverapp.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.happilyeverapp.R
import com.android.happilyeverapp.dataModels.roomDb.User
import com.android.happilyeverapp.dataModels.roomDb.UserViewModel

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val back: Button = findViewById(R.id.btn_back)
        back.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val btn_login: Button = findViewById(R.id.btn_submit_login)
        btn_login.setOnClickListener {
            val email = R.id.login_email.toString()
            val pwd = R.id.login_password.toString()

            if(!inputCheck(email, pwd)){
                val user: User = viewModel.login(email, pwd)
                if( user == null) {
                    Toast.makeText(this, "Check Credentials or Sign up", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this, "Logged in", Toast.LENGTH_LONG).show()
                    val intent: Intent = Intent(this, ProfileQuickActivity::class.java).putExtra("email", email)
                    startActivity(intent)
                }
            }
            else {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun inputCheck(email:String, pwd: String): Boolean {
        return (TextUtils.isEmpty(email) && TextUtils.isEmpty(pwd))
    }
}
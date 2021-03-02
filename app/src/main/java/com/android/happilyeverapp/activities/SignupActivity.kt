package com.android.happilyeverapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.happilyeverapp.R
import com.android.happilyeverapp.dataModels.roomDb.User
import com.android.happilyeverapp.dataModels.roomDb.UserViewModel

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val back: Button = findViewById(R.id.btn_back)
        back.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val btn_signup: Button = findViewById(R.id.btn_submit_signup)
        btn_signup.setOnClickListener {
            val name: EditText = findViewById(R.id.name)
            val phno: EditText = findViewById(R.id.phno)
            val email: EditText = findViewById(R.id.email)
            val pwd: EditText = findViewById(R.id.password)

//            if(inputCheck(name, phno, email, pwd)) {
                val user: User = User(0,name.text.toString(), phno.text.toString(), email.text.toString(), pwd.text.toString())
            println("User Signup "+user)
                val id: Long = viewModel.signup(user)
//            viewModel.signup(user)
                println("ID "+id)
                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()
                val intent: Intent = Intent(this, ProfileQuickActivity::class.java).putExtra("id", id)
//            val intent: Intent = Intent(this, ProfileQuickActivity::class.java).putExtra("email", user.email)
                startActivity(intent)
//            }
//            else {
//                Toast.makeText(this, "Fill all fields", Toast.LENGTH_LONG).show()
//            }
        }
    }
//    private fun inputCheck(name: String, phno: String, email:String, pwd: String): Boolean {
//        return (TextUtils.isEmpty(name) && TextUtils.isEmpty(phno) && TextUtils.isEmpty(email) && TextUtils.isEmpty(pwd))
//    }
}

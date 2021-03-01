package com.android.happilyeverapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.happilyeverapp.R

class ProfileBasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profilebasic)

        val btn_quick: Button = findViewById(R.id.btn_profile_quick)
        btn_quick.setOnClickListener {
            val intent: Intent = Intent(this, ProfileQuickActivity::class.java)
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
    }
}
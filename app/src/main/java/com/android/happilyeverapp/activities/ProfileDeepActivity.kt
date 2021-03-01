package com.android.happilyeverapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.happilyeverapp.R

class ProfileDeepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profiledeep)

        val btn_quick: Button = findViewById(R.id.btn_profile_quick)
        btn_quick.setOnClickListener {
            val intent: Intent = Intent(this, ProfileQuickActivity::class.java)
            startActivity(intent)
        }

        val btn_basic: Button = findViewById(R.id.btn_profile_basic)
        btn_basic.setOnClickListener {
            val intent: Intent = Intent(this, ProfileBasicActivity::class.java)
            startActivity(intent)
        }
    }
}
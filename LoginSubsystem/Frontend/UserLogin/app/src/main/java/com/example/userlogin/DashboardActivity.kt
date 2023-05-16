package com.example.userlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {

    private lateinit var welcomeText: String
    private lateinit var tvWelcome: TextView
    private lateinit var  btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        welcomeText ="Hey "+ getIntent().getStringExtra("Username").toString() + "!";
        tvWelcome = this.findViewById(R.id.tvWelcome);
        tvWelcome.setText(welcomeText);
//        btnLogout = findViewById(R.id.btnLogout)

//        btnLogout.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
////            startActivity(Intent(this, LogoutActivity::class.java))
//        }
    }
}
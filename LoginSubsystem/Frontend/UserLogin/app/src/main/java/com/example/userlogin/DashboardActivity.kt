package com.example.userlogin

import Fragment.Dashboard_Fragment
import Fragment.Logout_Fragment
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {

    private lateinit var welcomeText: String
    private lateinit var tvWelcome: TextView
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        welcomeText = "Hey " + getIntent().getStringExtra("Username").toString() + "!";
        tvWelcome = this.findViewById(R.id.tvWelcome);
        tvWelcome.setText(welcomeText);
        tvWelcome.setOnClickListener{
            Toast.makeText(this, "Logout listner", Toast.LENGTH_LONG).show();
        }
//        btnLogout = findViewById(R.id.btnLogout)

//        btnLogout.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
////            startActivity(Intent(this, LogoutActivity::class.java))
 fun dialog(){
    val builder: android.app.AlertDialog.Builder =
        android.app.AlertDialog.Builder(this)
    builder.setCancelable(true)
    builder.setTitle("Confirm Logout?")
    builder.setMessage("Are you sure you wish to log out?")
    builder.setPositiveButton("Confirm", { dialog, which ->
        finish()
    })
    builder.setNegativeButton(
        android.R.string.cancel,
        DialogInterface.OnClickListener { dialog, which ->
            //loadFragment(Dashboard_Fragment())

        })

    val dialog: android.app.AlertDialog? = builder.create()
    if (dialog != null) {
        dialog.show()
    }
    true
 }
        fun loadFragment(fragment: Fragment) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
        }
            loadFragment(Dashboard_Fragment())
            bottomNav = findViewById(R.id.bottomNav)
            bottomNav.setOnItemSelectedListener {
                when (it.itemId) {

                    R.id.dashboard -> {
                       // Toast.makeText(this, "this", Toast.LENGTH_LONG).show()
                        loadFragment(Dashboard_Fragment())

                        true

                    }

                    R.id.logoutFragment -> {

                        loadFragment(Logout_Fragment())
                        val builder: android.app.AlertDialog.Builder =
                            android.app.AlertDialog.Builder(this)
                        builder.setCancelable(true)
                        builder.setTitle("Confirm Logout?")
                        builder.setMessage("Are you sure you wish to log out?")
                        builder.setPositiveButton("Confirm", { dialog, which ->
                            finish()
                        })
                        builder.setNegativeButton(
                            android.R.string.cancel,
                            DialogInterface.OnClickListener { dialog, which ->
                                loadFragment(Dashboard_Fragment())

                            })

                        val dialog: android.app.AlertDialog? = builder.create()
                        if (dialog != null) {
                            dialog.show()
                        }
                        true
                    }

                    else -> {
                        true
                    }
                }
            }
        }
    }

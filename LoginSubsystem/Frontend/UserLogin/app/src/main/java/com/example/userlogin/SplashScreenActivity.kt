package com.example.userlogin


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

private lateinit var ivloginIcon: ImageView

class SplashScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//added rotation to the splashscreen

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN )
        val backgroundImage: ImageView = findViewById(R.id.iv_loginIcon)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        backgroundImage.startAnimation(slideAnimation)
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()}, 3000)



        ivloginIcon= findViewById(R.id.iv_loginIcon)

        ivloginIcon.alpha =0f
        ivloginIcon.animate().setDuration(2000).alpha(1f).withEndAction {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }


    }

package com.ihsan.introsliderpage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ihsan.introsliderpage.R
import com.ihsan.introsliderpage.ui.main.MainActivity

class SplashScreen : AppCompatActivity() {
    private val ivSplashScreen: ImageView by lazy {
        findViewById(R.id.iv_splash)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, MainActivity::class.java)
                .apply {
                    startActivity(this)
                }
            finish()
        }, 3000)
        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(ivSplashScreen)
    }
}
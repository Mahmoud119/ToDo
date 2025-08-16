package com.alamin.todo.ui.screens.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import com.alamin.todo.R
import com.alamin.todo.ui.screens.screens.main.MainActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        Handler().postDelayed({ val intent = Intent(this, MainActivity::class.java)
                              startActivity(intent)
                              }
        , 2000)

    }
}
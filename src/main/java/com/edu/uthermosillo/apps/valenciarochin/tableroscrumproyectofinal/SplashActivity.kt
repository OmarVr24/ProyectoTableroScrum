package com.edu.uthermosillo.apps.valenciarochin.tableroscrumproyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.Toast


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo);

        logo.setOnClickListener {
            Toast.makeText(
                this,
                "¡Aplastado!",
                Toast.LENGTH_SHORT).show()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}
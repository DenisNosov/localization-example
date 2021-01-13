package com.example.android.localizationexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.android.localizationexample.manager.LocalizationManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNextScreen = findViewById<TextView>(R.id.btn_next_screen)

        findViewById<ImageView>(R.id.iv_main).setImageDrawable(LocalizationManager.FirstScreen.image.localized)

        btnNextScreen.text = LocalizationManager.FirstScreen.next.localized
        btnNextScreen.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}
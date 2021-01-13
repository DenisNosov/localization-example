package com.example.android.localizationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android.localizationexample.manager.LocalizationManager

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<TextView>(R.id.tv_kingbird).text = LocalizationManager.SecondScreen.label.localized(2)
    }
}
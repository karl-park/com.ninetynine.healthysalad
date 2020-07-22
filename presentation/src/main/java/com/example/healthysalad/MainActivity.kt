package com.example.healthysalad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.data.Data
import com.example.domain.Base
import com.example.domain.Order

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val order = Order()
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.activity_main, TitleFragment())
            .addToBackStack(null).commit()
    }
}
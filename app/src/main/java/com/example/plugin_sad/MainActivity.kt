package com.example.plugin_sad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.btn).setOnClickListener {
            val clazz = TargetChangeClass()
            clazz.method1()
        }
    }
}

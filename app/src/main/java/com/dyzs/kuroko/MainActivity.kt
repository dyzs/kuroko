package com.dyzs.kuroko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Hello world")
    }
}

data class Person(val id: Int, val name: String)// 使用 Kotlin 的数据类声明一个 Person Bean 类
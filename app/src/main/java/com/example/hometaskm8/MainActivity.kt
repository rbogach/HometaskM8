package com.example.hometaskm8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    var textTitle :TextView? = null
    var editText : TextView? = null
    var tela: LinearLayoutCompat? = null
    var numClicks = 0
    var name =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.inputText)
        textTitle = findViewById(R.id.title)
        tela = findViewById(R.id.tela)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            changeTitle()
            numClicks++
        }

        editText?.addTextChangedListener{
            textTitle?.text = it?.toString()
            name = textTitle?.text.toString()
        }


    }

    fun changeTitle(){
        textTitle?.text = "$name Number of Clicks - $numClicks"
        when{
            numClicks % 2 ==0 -> tela?.background = getDrawable(R.drawable.sunrise)
            numClicks % 3 ==1-> tela?.background = getDrawable(R.drawable.evening)
            else-> tela?.background =getDrawable(R.drawable.sunset)
        }

    }
}
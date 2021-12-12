package com.example.apptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import kotlinx.coroutines.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


/*   android:onClick="onClick"
    fun observe(){
        val text = findViewById<EditText>(R.id.editText)
        val txt = findViewById<TextView>(R.id.textView)

        val network = Parse()

        val arr : ArrayList<String> = arrayListOf()

        network.kek(text.text.toString())
        val observImg = Observer<MutableList<String>> { elem ->
            elem.forEach {
                txt.text = it
                arr.add(it)
            }
        }
        network.getPics().observe(this,observImg)
    }

    fun onClick(view: android.view.View) {
        val text = findViewById<EditText>(R.id.editText)
        val txt = findViewById<TextView>(R.id.textView)

        val network = Parse()

        network.kek(text.text.toString())

        val observMsg = Observer<String> {
            txt.text = it
        }
        network.checkUrl().observe(this,observMsg)

  /*      val arr : ArrayList<String> = arrayListOf("kek")
        //val showImg = Intent(this, MainActivity2::class.java)

        val observImg = Observer<MutableList<String>> { elem ->
            elem.forEach {
                txt.text = it
                arr.add(it)
            }
        }
        network.getPics().observe(this,observImg)
   */

        if (txt.text != "incorrect link"){
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }
}

 */
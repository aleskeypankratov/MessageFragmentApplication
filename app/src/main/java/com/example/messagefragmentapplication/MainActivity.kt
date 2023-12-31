package com.example.messagefragmentapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        nextButton = findViewById(R.id.buttonNext)
        if (savedInstanceState != null) {
            textView.text = savedInstanceState.getString("text")
        }
        nextButton.setOnClickListener {
            val fragment = BlankFragment.newInstance(textView.text.toString())
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", textView.text.toString())
    }

    fun updateText(newText: String) {
        textView.text = newText
    }
}
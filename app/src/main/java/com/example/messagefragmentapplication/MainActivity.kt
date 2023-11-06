package com.example.messagefragmentapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), BlankFragment.OnTextChangeListener {
    private lateinit var textView: TextView
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        nextButton = findViewById(R.id.buttonNext)

        nextButton.setOnClickListener {
            val fragment = BlankFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onTextChange(text: String) {
        textView.text = text
    }
}
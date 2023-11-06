package com.example.messagefragmentapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {
    private lateinit var editText: EditText
    private var listener: OnTextChangeListener? = null

    interface OnTextChangeListener {
        fun onTextChange(text: String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        editText = view.findViewById(R.id.editTextMessage)
        val changeButton: Button = view.findViewById(R.id.buttonChange)
        changeButton.setOnClickListener {
            listener?.onTextChange(editText.text.toString())
            activity?.supportFragmentManager?.popBackStack()
        }
        return view
    }

    fun setOnTextChangeListener(listener: OnTextChangeListener) {
        this.listener = listener
    }
}


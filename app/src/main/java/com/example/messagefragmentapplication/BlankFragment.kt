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
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        editText = view.findViewById(R.id.editTextMessage)
        saveButton = view.findViewById(R.id.buttonChange)
        editText.setText(arguments?.getString("text"))
        saveButton.setOnClickListener {
            (activity as MainActivity).updateText(editText.text.toString())
            parentFragmentManager.popBackStack()
        }
        return view
    }

    companion object {
        fun newInstance(text: String): BlankFragment {
            val fragment = BlankFragment()
            val bundle = Bundle()
            bundle.putString("text", text)
            fragment.arguments = bundle
            return fragment
        }
    }
}
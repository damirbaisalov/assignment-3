package kz.app.assignment3.exercise2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import kz.app.assignment3.R

class FragmentInput: Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        val editText = view.findViewById<TextView>(R.id.input_edit_text)
        val button = view.findViewById<Button>(R.id.input_button)

        button.setOnClickListener {
            sharedViewModel.updateText(editText.text.toString())
            findNavController().navigate(R.id.action_inputFragment_to_outputFragment)
        }

        return view
    }
}
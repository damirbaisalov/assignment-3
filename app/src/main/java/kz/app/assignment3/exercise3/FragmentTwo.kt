package kz.app.assignment3.exercise3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kz.app.assignment3.R

class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two, container, false)
        val textView = view.findViewById<TextView>(R.id.textView_fragment_two)
        textView.text = "Fragment Two"

        return view
    }
}
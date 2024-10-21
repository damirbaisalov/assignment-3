package kz.app.assignment3.exercise2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kz.app.assignment3.R

class FragmentOutput: Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_output, container, false)

        val textView = view.findViewById<TextView>(R.id.output_text_view)
        sharedViewModel.text.observe(viewLifecycleOwner) { text ->
            textView.text = text
        }
        return view
    }
}
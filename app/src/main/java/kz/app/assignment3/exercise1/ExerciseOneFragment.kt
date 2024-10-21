package kz.app.assignment3.exercise1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kz.app.assignment3.EXERCISE_ONE_TAG
import kz.app.assignment3.R

class ExerciseOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(EXERCISE_ONE_TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_exercise_one, container, false)

        val textView = view.findViewById<TextView>(R.id.hello_text_view)
        textView.text = "Hello from Fragment!"

        return view
    }

    override fun onStart() {
        super.onStart()
        Log.d(EXERCISE_ONE_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(EXERCISE_ONE_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(EXERCISE_ONE_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(EXERCISE_ONE_TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(EXERCISE_ONE_TAG, "onDestroyView")
    }
}

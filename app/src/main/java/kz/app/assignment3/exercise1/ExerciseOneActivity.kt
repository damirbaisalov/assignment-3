package kz.app.assignment3.exercise1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kz.app.assignment3.R

class ExerciseOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navigateToExerciseOneFragment()
    }

    private fun navigateToExerciseOneFragment() {
        val helloFragment = ExerciseOneFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, helloFragment)
            .commit()
    }
}
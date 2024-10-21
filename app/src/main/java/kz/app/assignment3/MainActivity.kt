package kz.app.assignment3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kz.app.assignment3.exercise1.ExerciseOneActivity
import kz.app.assignment3.exercise2.ExerciseTwoActivity
import kz.app.assignment3.exercise3.ExerciseThreeActivity
import kz.app.assignment3.exercise46.ExWithRecyclerActivity
import kz.app.assignment3.exercise78.ExWithLiveDataActivity
import kz.app.assignment3.models.ExerciseType

class MainActivity : AppCompatActivity() {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button46: Button
    private lateinit var button78: Button
    private lateinit var button9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button1 = findViewById(R.id.exercise_one_button)
        button2 = findViewById(R.id.exercise_two_button)
        button3 = findViewById(R.id.exercise_three_button)
        button46 = findViewById(R.id.exercise_four_six_button)
        button78 = findViewById(R.id.exercise_seven_eight_button)
        button9 = findViewById(R.id.exercise_nine_button)

        button1.setOnClickListener { navigateToExercise(ExerciseType.ONE) }
        button2.setOnClickListener { navigateToExercise(ExerciseType.TWO) }
        button3.setOnClickListener { navigateToExercise(ExerciseType.THREE) }
        button46.setOnClickListener { navigateToExercise(ExerciseType.FOUR_SIX) }
        button78.setOnClickListener { navigateToExercise(ExerciseType.SEVEN_EIGHT) }
        button9.setOnClickListener { navigateToExercise(ExerciseType.NINE) }
    }

    private fun navigateToExercise(exerciseType: ExerciseType) {
        val destinationActivity = when (exerciseType) {
            ExerciseType.ONE -> ExerciseOneActivity::class.java
            ExerciseType.TWO -> ExerciseTwoActivity::class.java
            ExerciseType.THREE -> ExerciseThreeActivity::class.java
            ExerciseType.FOUR_SIX -> ExWithRecyclerActivity::class.java
            ExerciseType.SEVEN_EIGHT -> ExWithLiveDataActivity::class.java
            ExerciseType.NINE -> ExWithLiveDataActivity::class.java
        }
        val intent = Intent(this, destinationActivity)
        startActivity(intent)
    }
}
package kz.app.assignment3.exercise3

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kz.app.assignment3.R

class ExerciseThreeActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_three)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fragmentManager = supportFragmentManager

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentOne())
                .commit()
        }

        val buttonOneAdd = findViewById<Button>(R.id.button_first_add)
        val buttonTwoAdd = findViewById<Button>(R.id.button_second_add)
        val buttonReplaceWithFirst = findViewById<Button>(R.id.button_first_replace)
        val buttonReplaceWithSecond = findViewById<Button>(R.id.button_second_replace)

        val buttonRemove = findViewById<Button>(R.id.button_remove)

        buttonOneAdd.setOnClickListener {
            addFragment(FragmentOne())
        }

        buttonTwoAdd.setOnClickListener {
            addFragment(FragmentTwo())
        }

        buttonReplaceWithFirst.setOnClickListener {
            replaceFragment(FragmentTwo())
        }

        buttonReplaceWithSecond.setOnClickListener {
            replaceFragment(FragmentOne())
        }

        buttonRemove.setOnClickListener {
            removeFragment()
        }
    }

    private fun addFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun removeFragment() {
        val fragment = fragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment != null) {
            fragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
        }
    }
}
package kz.app.assignment3.exercise46

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.app.assignment3.R
import kz.app.assignment3.models.Movie

class ExWithRecyclerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_with_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)
        movieAdapter = MovieAdapter(loadMovies()) { movie ->
            Toast.makeText(this, movie.title, Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = movieAdapter
    }

    private fun loadMovies(): List<Movie> {
        return listOf(
            Movie("Movie 1", "Movie 1 description"),
            Movie("Movie 2", "Movie 2 description"),
            Movie("Movie 3", "Movie 3 description"),
            Movie("Movie 4", "Movie 4 description"),
            Movie("Movie 5", "Movie 5 description"),
            Movie("Movie 6", "Movie 6 description"),
            Movie("Movie 7", "Movie 7 description"),
            Movie("Movie 8", "Movie 8 description"),
            Movie("Movie 9", "Movie 9 description"),
            Movie("Movie 10", "Movie 10 description"),
            Movie("Movie 11", "Movie 11 description"),
            Movie("Movie 12", "Movie 12 description"),
            Movie("Movie 13", "Movie 13 description"),
            Movie("Movie 14", "Movie 14 description")
        )
    }
}
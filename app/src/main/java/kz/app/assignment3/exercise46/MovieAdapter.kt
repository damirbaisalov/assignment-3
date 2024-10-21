package kz.app.assignment3.exercise46

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.app.assignment3.R
import kz.app.assignment3.models.Movie

class MovieAdapter(
    private val movies: List<Movie>,
    private val onMovieClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.item_movie_title)
        val description: TextView = view.findViewById(R.id.item_movie_description)

        fun bind(movie: Movie, clickListener: (Movie) -> Unit) {
            title.text = movie.title
            description.text = movie.description
            itemView.setOnClickListener { clickListener(movie) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
//        holder.title.text = movie.title
//        holder.description.text = movie.description
//        holder.itemView.setOnClickListener { onMovieClick(movie) }
        // FIRST APPROACH

        holder.bind(movie, onMovieClick)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

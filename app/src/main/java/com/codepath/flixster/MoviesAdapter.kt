package com.codepath.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesAdapter(private val movies: List<Movie>, private val listener: OnListFragmentInteractionListener) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.movieTitle)
        val overviewTextView: TextView = view.findViewById(R.id.movieOverview)
        val posterImageView: ImageView = view.findViewById(R.id.moviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleTextView.text = movie.title
        holder.overviewTextView.text = movie.overview

        Glide.with(holder.posterImageView.context)
            .load("https://image.tmdb.org/t/p/w500/${movie.poster_path}")
            .into(holder.posterImageView)

        // Set an OnClickListener on the itemView to invoke listener.onItemClick with the current movie
        holder.itemView.setOnClickListener {
            listener.onItemClick(movie)
        }
    }

    override fun getItemCount() = movies.size
}

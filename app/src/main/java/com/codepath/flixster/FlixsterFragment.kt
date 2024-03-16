package com.codepath.flixster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlixsterFragment : Fragment(), OnListFragmentInteractionListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ContentLoadingProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_flixster, container, false)
        progressBar = view.findViewById(R.id.progressBar)
        recyclerView = view.findViewById(R.id.RecyclerViewMovies)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        fetchMovies()
        return view
    }

    private fun fetchMovies() {
        val movieApiService = RetrofitClient.instance.create(MovieApiService::class.java)
        movieApiService.getNowPlaying().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movies = response.body()?.results ?: emptyList()
                    recyclerView.adapter = MoviesAdapter(movies, this@FlixsterFragment)
                    progressBar.visibility = View.GONE
                } else {
                    Toast.makeText(context, "Failed to retrieve movies.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onItemClick(item: Movie) {
        Toast.makeText(context, "Clicked on: ${item.title}", Toast.LENGTH_SHORT).show()
    }
}

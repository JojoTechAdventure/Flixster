package com.codepath.flixster

/**
 * This interface is used by the [MoviesAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [FlixsterFragment]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: Movie)
}

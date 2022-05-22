package com.davevarga.flareon.repository

import androidx.lifecycle.LiveData
import com.davevarga.flareon.db.MovieDao
import com.davevarga.flareon.models.GenreString
import com.davevarga.flareon.models.Movie

class MovieRepository(private val movieDao: MovieDao) {

    fun getCollection(): LiveData<MutableList<Movie>> = movieDao.getCollection()

    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun insertGenres(genres: GenreString) {
        movieDao.insertGenres(genres)
    }

    suspend fun deleteMovie(id: Int) {
        movieDao.deleteMovie(id)
    }

}
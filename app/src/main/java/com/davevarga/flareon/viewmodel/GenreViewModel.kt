package com.davevarga.flareon.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.davevarga.flareon.models.GenreString
import com.davevarga.flareon.repository.MovieRepository
import com.davevarga.flareon.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenreViewModel @Inject constructor(
    application: Application,
    private val networkRepository: NetworkRepository,
    private val movieRepository: MovieRepository
) : AndroidViewModel(application) {

    var genreList = liveData(Dispatchers.IO) {
        emit(networkRepository.getAllGenres())
    }

    fun insert(genres: GenreString) {
        viewModelScope.launch {
            movieRepository.insertGenres(genres)
        }
    }
}
package com.example.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.GetMovieGenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieGenreRepository: GetMovieGenreRepository
) : ViewModel() {


    init {
        viewModelScope.launch {
            getMovieGenreRepository.fetchGenres().collect {

            }
        }

    }
}
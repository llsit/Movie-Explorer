package com.example.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Result
import com.example.core.data.repository.GetMovieGenreRepository
import com.example.core.model.response.GenreListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieGenreRepository: GetMovieGenreRepository
) : ViewModel() {

    private val _genres = MutableStateFlow(UiState(genresList = emptyList()))
    val uiState: StateFlow<UiState> = _genres.asStateFlow()

    init {
        getGenres()
    }

    private fun getGenres() {
        viewModelScope.launch {
            getMovieGenreRepository.fetchGenres().collect {
                when (it) {
                    is Result.Error -> {
                        Log.d("HomeViewModel", it.exception.message.toString())
                        _genres.update { it2 ->
                            it2.copy(genresList = emptyList())
                        }
                    }

                    is Result.Success<GenreListResponse> -> {
                        _genres.update { it2 ->
                            it2.copy(genresList = it.data.genres)
                        }
                    }
                }
            }
        }
    }
}
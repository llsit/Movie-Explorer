package com.example.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.usecase.GetHomeShelfUseCase
import com.example.core.model.model.Shelf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeShelfUseCase: GetHomeShelfUseCase
) : ViewModel() {

    private val _shelves = MutableStateFlow<List<Shelf>>(emptyList())
    val shelves: StateFlow<List<Shelf>> = _shelves.asStateFlow()

    init {
        fetchShelf()
    }

    private fun fetchShelf() {
        viewModelScope.launch {
            getHomeShelfUseCase.getHomeShelf().collect {
                _shelves.value = it
            }
        }
    }
}
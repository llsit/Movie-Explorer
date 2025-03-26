package com.example.core.domain.usecase

import com.example.core.data.repository.GetPopularMovieRepository
import com.example.core.model.model.Shelf
import com.example.core.model.model.ShelfItem
import com.example.core.model.model.ShelfType
import com.example.core.model.response.PopularMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetHomeShelfUseCase {
    fun getHomeShelf(): Flow<List<Shelf>>
}

class GetHomeShelfUseCaseImp @Inject constructor(
    private val getPopularMovieRepository: GetPopularMovieRepository
) : GetHomeShelfUseCase {
    override fun getHomeShelf(): Flow<List<Shelf>> = flow {
        val shelfList = mutableListOf<Shelf>()
        withContext(Dispatchers.IO) {
            val popularMovieDeferred = async { getPopularMovieRepository.fetchPopular() }

            shelfList.add(
                Shelf(
                    ShelfType.Popular,
                    convertModelToShelfItem(popularMovieDeferred.await().single().getOrNull())
                ),
            )
        }
        emit(shelfList.toList())
    }

    private fun convertModelToShelfItem(response: PopularMovieResponse?): List<ShelfItem> {
        return response?.results?.map {
            ShelfItem(
                id = it.id,
                originalTitle = it.originalTitle,
                genreIds = it.genreIds,
                posterPath = it.posterPath,
                popularity = it.popularity,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate
            )
        } ?: emptyList()
    }
}
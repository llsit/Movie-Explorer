package com.example.core.domain.usecase

import com.example.common.getFullPosterUrl
import com.example.core.data.repository.GetPopularMovieRepository
import com.example.core.data.repository.GetTopRatedMovieRepository
import com.example.core.data.repository.GetUpcomingMovieRepository
import com.example.core.model.model.Shelf
import com.example.core.model.model.ShelfItem
import com.example.core.model.model.ShelfType
import com.example.core.model.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.single
import javax.inject.Inject

interface GetHomeShelfUseCase {
    fun getHomeShelf(): Flow<List<Shelf>>
}

class GetHomeShelfUseCaseImp @Inject constructor(
    private val getPopularMovieRepository: GetPopularMovieRepository,
    private val getTopRatedMovieRepository: GetTopRatedMovieRepository,
    private val getUpcomingMovieRepository: GetUpcomingMovieRepository
) : GetHomeShelfUseCase {
    override fun getHomeShelf(): Flow<List<Shelf>> = flow {
        coroutineScope {
            val popularMovieDeferred = async { getPopularMovieRepository.fetchPopular() }
            val topRatedMovieDeferred = async { getTopRatedMovieRepository.fetchTopRated() }
            val upcomingMovieDeferred = async { getUpcomingMovieRepository.fetchUpcoming() }

            val shelfList = listOf(
                Shelf(
                    type = ShelfType.Upcoming,
                    titleShelf = ShelfType.Popular.toString(),
                    items = convertModelToShelfItem(
                        upcomingMovieDeferred.await().single().getOrNull()
                    )
                ),
                Shelf(
                    type = ShelfType.Popular,
                    titleShelf = ShelfType.Popular.toString(),
                    items = convertModelToShelfItem(
                        popularMovieDeferred.await().single().getOrNull()
                    )
                ),
                Shelf(
                    type = ShelfType.TopRate,
                    titleShelf = ShelfType.TopRate.toString(),
                    items = convertModelToShelfItem(
                        topRatedMovieDeferred.await().single().getOrNull()
                    )
                )
            )
            emit(shelfList)
        }
    }.flowOn(Dispatchers.IO)

    private fun convertModelToShelfItem(response: MovieResponse?): List<ShelfItem> {
        return response?.results?.map {
            ShelfItem(
                id = it.id,
                originalTitle = it.originalTitle,
                genreIds = it.genreIds,
                posterPath = it.posterPath.getFullPosterUrl(),
                popularity = it.popularity,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate
            )
        } ?: emptyList()
    }
}
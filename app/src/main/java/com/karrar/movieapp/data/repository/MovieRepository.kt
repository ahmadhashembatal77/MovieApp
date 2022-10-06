package com.karrar.movieapp.data.repository

import com.karrar.movieapp.data.local.database.entity.SearchHistoryEntity
import com.karrar.movieapp.data.remote.State
import com.karrar.movieapp.data.remote.response.*
import com.karrar.movieapp.domain.models.*
import com.karrar.movieapp.data.remote.response.movieDetailsDto.RatingDto
import com.karrar.movieapp.domain.models.ActorDetails
import com.karrar.movieapp.domain.models.Actor
import com.karrar.movieapp.domain.models.Genre
import com.karrar.movieapp.domain.models.Media
import com.karrar.movieapp.domain.models.PopularMovie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getPopularMovies(): Flow<State<List<PopularMovie>>>

    fun getUpcomingMovies(): Flow<State<List<Media>>>

    fun getTopRatedMovies(): Flow<State<List<Media>>>

    fun getNowPlayingMovies(): Flow<State<List<Media>>>

    fun getTrendingMovies(): Flow<State<List<Media>>>

    //fun getTrendingPersons(): Flow<State<List<Actor>>>

    fun searchForPerson(query: String): Flow<State<List<MediaInfo>>>

    fun searchForMovie(query: String): Flow<State<List<MediaInfo>>>

    fun searchForSeries(query: String): Flow<State<List<MediaInfo>>>

    fun getGenreList(): Flow<State<List<Genre>>>

    fun getMovieListByGenre(genreID: Int): Flow<State<List<Media>>>

    fun getActorDetails(actorId: Int): Flow<State<ActorDetails>>

    suspend fun insertSearchItem(item: SearchHistoryEntity)

    suspend fun deleteSearchItem(item: SearchHistoryEntity)

    fun getAllSearchHistory(): Flow<List<SearchHistory>>

    fun getTrendingActors(): Flow<State<List<Actor>>>

    fun getActorMovies(actorId: Int): Flow<State<List<Media?>>>

    fun getDailyTrending(): Flow<State<List<Trend>>>

    fun getAllMovies(): Flow<State<List<Media>>>

    fun getMovieDetails(movieId: Int): Flow<State<MovieDetails>>

    fun getMovieCast(movieId: Int): Flow<State<List<Cast>>>

    fun getSimilarMovie(movieId: Int): Flow<State<List<Media>>>

    fun getMovieReviews(movieId: Int): Flow<State<List<Review>>>

    fun setRating(movieId: Int, value:Float, session_id: String): Flow<State<RatingDto>>

    fun getMovieTrailer(movieId: Int): Flow<State<Trailer>>

    fun getAllLists(accountId: Int,session_id:String): Flow<State<BaseResponse<CreatedListDto>>>

    fun addMovieToList(sessionId: String, list_id: Int, movie_id: Int): Flow<State<AddMovieDto>>

    fun getListDetails(listId: Int): Flow<State<ListDetailsDto>>

    fun getRatedMovie(accountId: Int, session_id: String): Flow<State<BaseResponse<RatedMovie>>>

}
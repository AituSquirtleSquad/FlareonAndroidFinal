package com.davevarga.flareon.network

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.davevarga.flareon.models.Movie
import com.davevarga.flareon.repository.NetworkState
import com.davevarga.flareon.util.API_KEY
import com.davevarga.flareon.util.END_OF_YEAR
import com.davevarga.flareon.util.FIRST_PAGE
import com.davevarga.flareon.util.START_OF_YEAR
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDataSource(
    private val apiService: GetData,
    private val compositeDisposable: CompositeDisposable,
    val minYear: String,
    val maxYear: String,
    val genre: String
) : PageKeyedDataSource<Int, Movie>() {


    private var page = FIRST_PAGE

    val networkState: MutableLiveData<NetworkState> = MutableLiveData()


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {

        networkState.postValue(NetworkState.LOADING)

        compositeDisposable.add(
            apiService.getFilteredMovies(
                API_KEY,
                minYear + START_OF_YEAR,
                maxYear + END_OF_YEAR,
                genre,
                page
            )
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        callback.onResult(it.movieList, null, page + 1)
                        networkState.postValue(NetworkState.LOADED)
                    },
                    {
                        networkState.postValue(NetworkState.ERROR)
                    }
                )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        networkState.postValue(NetworkState.LOADING)

        compositeDisposable.add(
            apiService.getFilteredMovies(
                API_KEY,
                minYear + START_OF_YEAR,
                maxYear + END_OF_YEAR,
                genre,
                params.key
            )
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        if (it.totalPages >= params.key) {
                            callback.onResult(it.movieList, params.key + 1)
                            networkState.postValue(NetworkState.LOADED)
                        } else {
                            networkState.postValue(NetworkState.ENDOFLIST)
                        }
                    },
                    {
                        networkState.postValue(NetworkState.ERROR)
                    }
                )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }
}
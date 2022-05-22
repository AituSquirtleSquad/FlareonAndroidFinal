package com.davevarga.flareon.di

import com.davevarga.flareon.db.MovieDao
import com.davevarga.flareon.network.GetData
import com.davevarga.flareon.repository.MovieRepository
import com.davevarga.flareon.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieDao: MovieDao): MovieRepository {
        return MovieRepository(movieDao)
    }

    @Singleton
    @Provides
    fun provideNetworkRepository(apiService: GetData): NetworkRepository {
        return NetworkRepository(apiService)
    }
}
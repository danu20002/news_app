package com.danunaik.news_data.di

import com.danunaik.news_data.network.NetworkApiService
import com.danunaik.news_data.repository.NewsRepoImpl
import com.danunaik.news_domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object NewsDataModule {
    @Provides
    fun providesNewsApiService(retrofit:Retrofit): NetworkApiService{
        return retrofit.create(NetworkApiService::class.java)
    }
    @Provides
    fun providesNewsRepsoitory(newsApiService: NetworkApiService):NewsRepository{
        return NewsRepoImpl(newsApiService )
    }
}
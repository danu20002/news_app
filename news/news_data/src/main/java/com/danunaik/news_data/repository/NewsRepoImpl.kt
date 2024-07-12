package com.danunaik.news_data.repository

import com.danunaik.news_data.mapper.toDomainArticle
import com.danunaik.news_data.network.NetworkApiService
import com.danunaik.news_domain.model.Article
import com.danunaik.news_domain.repository.NewsRepository

class NewsRepoImpl(private val newsApiService: NetworkApiService): NewsRepository {
    override suspend fun getNewsArticle(): List<Article> {
        return newsApiService.getNewsArticle().articles.map { it.toDomainArticle() }
    }
}
package com.danunaik.news_domain.repository

import com.danunaik.news_domain.model.Article

interface NewsRepository {
    suspend fun getNewsArticle():List<Article>


}
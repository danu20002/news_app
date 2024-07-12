package com.danunaik.news_data.mapper

import com.danunaik.news_data.model.ArticleDTO
import com.danunaik.news_domain.model.Article

fun ArticleDTO.toDomainArticle():Article{
    return Article(
        author=this.author,
        content=this.content,
        description=this.description,
         title=this.title,
        urlToImage=this.urlToImage
    )
}
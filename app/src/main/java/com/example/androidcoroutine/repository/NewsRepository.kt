package com.example.androidcoroutine.repository

import com.example.androidcoroutine.api.RetrofitInstance
import com.example.androidcoroutine.db.ArticleDatabase
import com.example.androidcoroutine.models.Article

class NewsRepository(val db:ArticleDatabase) {
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) = RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery:String, pageNumber: Int) = RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article:Article) = db.getArticleDao().upsert(article)

    suspend fun delete(article:Article) = db.getArticleDao().deleteArticle(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()
}
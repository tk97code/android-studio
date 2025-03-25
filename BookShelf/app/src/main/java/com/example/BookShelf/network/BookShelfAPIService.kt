package com.example.BookShelf.network

import com.example.BookShelf.model.Book
import com.example.BookShelf.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookShelfAPIService {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): Response<SearchResponse>

    @GET("volume/{id}")
    suspend fun getBook(@Path("id") id: String): Response<Book>
}
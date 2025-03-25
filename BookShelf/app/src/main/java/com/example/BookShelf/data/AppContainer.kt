package com.example.BookShelf.data

import com.example.BookShelf.network.BookShelfAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppContainer {
    val bookshelfApiService: BookShelfAPIService
    val bookshelfRepository: BookShelfRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    override val bookshelfApiService: BookShelfAPIService by lazy {
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create()
    }

    override val bookshelfRepository: BookShelfRepository by lazy {
        DefaultBookshelfRepository(bookshelfApiService)
    }
}
package com.example.BookShelf.data

import com.example.BookShelf.model.Book
import com.example.BookShelf.network.BookShelfAPIService

interface BookShelfRepository {
    suspend fun getBooks(query: String): List<Book>?

    suspend fun getBook(query: String): Book?
}

class DefaultBookshelfRepository(
    private val bookshelfApiService: BookShelfAPIService
) : BookShelfRepository {
    /** Retrieves list of Volumes from underlying data source */
    // Notes: List<Book>? NULLABLE
    override suspend fun getBooks(query: String): List<Book>? {
        return try {
            val res = bookshelfApiService.getBooks(query)
            if (res.isSuccessful) {
                res.body()?.items ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getBook(id: String): Book? {
        return try {
            val res = bookshelfApiService.getBook(id)
            if (res.isSuccessful) {
                res.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
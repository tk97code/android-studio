package com.example.BookShelf.model

data class SearchResponse(
    val items: List<Book>?,
    val totalItems: Int,
    val kind: String,
)
package com.example.BookShelf.ui.SearchSceen

import com.example.BookShelf.model.Book

sealed interface SearchUiState {
    data class Success(val bookshelfList: List<Book>) : SearchUiState
    object Error : SearchUiState
    object Loading : SearchUiState
}
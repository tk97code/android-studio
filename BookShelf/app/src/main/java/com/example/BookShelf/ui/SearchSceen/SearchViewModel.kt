package com.example.BookShelf.ui.SearchSceen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.BookShelf.data.BookShelfRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class SearchViewModel(
    private val bookshelfRepository: BookShelfRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Loading)
    val uiState = _uiState.asStateFlow()

    var selectedBookId by mutableStateOf("")


    private val _uiStateQuery = MutableStateFlow(QueryUiState())
    val uiStateQuery = _uiStateQuery.asStateFlow()

    fun updateQuery(query: String){
        _uiStateQuery.update { currentState ->
            currentState.copy(
                query = query
            )
        }
    }

    fun updateSearchStarted(searchStarted: Boolean){
        _uiStateQuery.update { currentState ->
            currentState.copy(
                searchStarted = searchStarted
            )
        }
    }

    fun getBooks(query: String = "") { //  "travel"
        updateSearchStarted(true)
        viewModelScope.launch {
            _uiState.value = SearchUiState.Loading

            _uiState.value = try {
                // Notes: List<Book>? NULLABLE
                val books = bookshelfRepository.getBooks(query)
                if (books == null) {
                    SearchUiState.Error
                } else if (books.isEmpty()){
                    SearchUiState.Success(emptyList())
                } else{
                    SearchUiState.Success(books)
                }
            } catch (e: IOException) {
                SearchUiState.Error
            } catch (e: HttpException) {
                SearchUiState.Error
            }
        }
    }

}
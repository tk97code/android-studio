package com.example.BookShelf

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.BookShelf.ui.SearchSceen.SearchViewModel

@Composable
fun BookshelfNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel : SearchViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppDestinations.SearchScreen.name,
        modifier = modifier
    ) {

//        composable(route = AppDestinations.MenuScreen.name) {
//            MenuScreen(
//                onSearchClick = {
//                    navController.navigate(AppDestinations.QueryScreen.name)
//                },
//                onFavClick = {
//                    navController.navigate(AppDestinations.FavoriteScreen.name)
//                }
//            )
//        }
//
//        composable(route = AppDestinations.QueryScreen.name) {
//            QueryScreen(
//                viewModel = viewModel,
//                retryAction = { viewModel.getBooks() },
//                onDetailsClick = {
//                    viewModel.selectedBookId = it.id
//                    navController.navigate(AppDestinations.DetailScreen.name)
//                },
//            )
//        }
//
//        composable(route = AppDestinations.FavoriteScreen.name) {
//            FavoritesScreen(
//                viewModel = viewModel,
//                retryAction = { viewModel.getBooks() },
//                bookshelfUiState = viewModel.favoritesfUiState
//            )
//        }
//
//        composable(route = AppDestinations.DetailScreen.name) {
//            val detailViewModel : DetailsViewModel = viewModel(factory = DetailsViewModel.Factory)
//            detailViewModel.getBook(viewModel.selectedBookId)
//
//            DetailScreen(
//                viewModel = detailViewModel,
//                retryAction = { detailViewModel.getBook(viewModel.selectedBookId) },
//            )
//        }
    }
}
package com.example.BookShelf.ui.SearchSceen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.BookShelf.R
import com.example.BookShelf.model.Book
import com.example.BookShelf.ui.Component.NothingFoundScreen

@Composable
fun GridList(
    viewModel: SearchViewModel,
    bookshelfList: List<Book>,
    modifier: Modifier = Modifier,
    onDetailsClick: (Book) -> Unit,
) {
    if (bookshelfList.isEmpty()) {
        NothingFoundScreen()
    } else {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(24.dp),
        ) {
            items(bookshelfList.size) { index ->
                val book = bookshelfList[index]
                GridItem(
                    viewModel = viewModel,
                    book = book,
                    onDetailsClick = onDetailsClick,
                )
            }
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GridItem(
    viewModel: SearchViewModel,
    book: Book,
    modifier: Modifier = Modifier,
    onDetailsClick: (Book) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var favorite by remember { mutableStateOf(false) }

//    favorite = viewModel.isBookFavorite(book)
//    Log.d(TAG, viewModel.favoriteBooks.size.toString())

    Card(
        onClick = { onDetailsClick(book) },
        //elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
            .fillMaxWidth()
            //.border(2.dp, Color.Green)
            .padding(8.dp)
        //.aspectRatio(1f),

    ) {
        Column(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .aspectRatio(.6f),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(book.volumeInfo.imageLinks?.thumbnail)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentScale = ContentScale.FillBounds
            )
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                //.border(1.dp, Color.Blue),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
                // Notes: Question: I would like onFavoriteClick to be hoisted up.. all the way to QueryScreen
                //  because I do not like passing the viewModel this far down.
                //  I am not sure how to get this done. To me it seems that
                //  I would have to pass the book `onFavoriteClick(book)` up, and favorite state
                //  would have to be created hight up too... just not sure how...
//                FavoriteButton(
//                    favorite = favorite,
//                    onFavoriteClick = {
//                        if (favorite) {
//                            viewModel.removeFavoriteBook(book)
//                        } else {
//                            viewModel.addFavoriteBook(book)
//                        }
//                        favorite = !favorite
//                    },
//                )
//                ExpandButton(
//                    onClick = { expanded = !expanded },
//                    expanded = expanded
//                )
            }
//            if (expanded) {
//                Column() {
//                    // Notes: Question: Is there a way to bold just a part of the string?
//                    //  I red that we can use <b> and <i> and others...
//                    //  but is is not working...inside res > strings.xml
//                    Text(
//                        text = stringResource(R.string.book_title, book.volumeInfo.title),
//                        style = MaterialTheme.typography.bodyLarge
//                    )
//                    Text(
//                        text = stringResource(R.string.book_subtitle, book.volumeInfo.subtitle),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                    Text(
//                        text = stringResource(R.string.book_authors, book.volumeInfo.allAuthors()),
//                        style = MaterialTheme.typography.bodySmall
//                    )
//                    Text(
//                        text = stringResource(R.string.book_price, book.saleInfo.getPrice2),
//                        style = MaterialTheme.typography.bodyLarge
//                    )
//                }
//            }
//        }
    }

}
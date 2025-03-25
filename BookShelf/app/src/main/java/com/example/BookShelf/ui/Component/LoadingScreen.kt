package com.example.BookShelf.ui.Component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.BookShelf.ui.theme.BookShelfTheme

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        // Notes: Commented out code, also ok instead of CircularProgressIndicator
        //Image(
        //    modifier = Modifier.size(200.dp),
        //    painter = painterResource(R.drawable.loading_img),
        //    contentDescription = stringResource(R.string.loading)
        //)
        CircularProgressIndicator()
    }
}


@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
    BookShelfTheme {
        LoadingScreen()
    }
}
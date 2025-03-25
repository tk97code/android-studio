package com.example.BookShelf

import android.app.Application
import com.example.BookShelf.data.AppContainer
import com.example.BookShelf.data.DefaultAppContainer

class BookshelfApplication: Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
package com.example.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Dessert(
    @IntegerRes val dayRes: Int,
    @StringRes val nameRes: Int,
    @StringRes val goalRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
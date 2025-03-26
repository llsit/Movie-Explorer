package com.example.core.model.model

sealed class ShelfType {
    data object Popular : ShelfType()
    data object TopRate : ShelfType()
    data object Upcoming : ShelfType()
}

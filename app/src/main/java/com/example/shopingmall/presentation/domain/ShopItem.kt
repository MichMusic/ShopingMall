package com.example.shopingmall.presentation.domain

data class ShopItem(
    val name: String,
    val counter: Int,
    val having: Boolean,
    var id: Int = undefinedId
) {
    companion object {
        const val undefinedId = -1
    }
}

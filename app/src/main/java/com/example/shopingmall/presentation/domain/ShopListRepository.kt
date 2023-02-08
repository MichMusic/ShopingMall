package com.example.shopingmall.presentation.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addingItem(shopItem: ShopItem)

    fun editingShopItem(shopItem: ShopItem)

    fun deleting(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int) : ShopItem

    fun getShopList(): LiveData<List<ShopItem>>
}
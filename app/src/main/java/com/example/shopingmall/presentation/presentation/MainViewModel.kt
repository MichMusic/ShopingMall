package com.example.shopingmall.presentation.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopingmall.presentation.data.ShopListRepositoryImpl
import com.example.shopingmall.presentation.domain.EditShopItemUseCase
import com.example.shopingmall.presentation.domain.ShopItem
import com.example.shopingmall.presentation.domain.deleteIShoptemUseCase

import com.example.shopingmall.presentation.domain.getShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = getShopListUseCase(repository)
    private val deleteShopListUseCase = deleteIShoptemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopListUseCase.deleting(shopItem)
    }
    fun changeEditing(shopItem: ShopItem) {
        val newItem = shopItem.copy(having = !shopItem.having)
        editShopListUseCase.editingShopItem(newItem)
    }
}
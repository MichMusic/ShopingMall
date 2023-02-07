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

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }
}
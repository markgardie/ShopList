package com.example.shoplist.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplist.data.repositories.ShopListRepositoryImpl
import com.example.shoplist.domain.models.ShopItem
import com.example.shoplist.domain.use_cases.DeleteShopitemUseCase
import com.example.shoplist.domain.use_cases.EditShopItemUseCase
import com.example.shoplist.domain.use_cases.GetShopListUseCase

class MainViewModel : ViewModel() {

    val repository = ShopListRepositoryImpl

    val getShopListUseCase = GetShopListUseCase(repository)
    val editShopItemUseCase = EditShopItemUseCase(repository)
    val deleteShopItemUseCase = DeleteShopitemUseCase(repository)

    var shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}
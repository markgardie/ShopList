package com.example.shoplist.domain.use_cases

import com.example.shoplist.domain.models.ShopItem
import com.example.shoplist.domain.repositories.ShopListRepository

class DeleteShopitemUseCase(
    val shopListRepository: ShopListRepository) {

    fun deleteShopItem (shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}
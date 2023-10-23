package com.example.shoplist.domain.use_cases

import com.example.shoplist.domain.models.ShopItem
import com.example.shoplist.domain.repositories.ShopListRepository
import javax.inject.Inject

class AddShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository) {

    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}
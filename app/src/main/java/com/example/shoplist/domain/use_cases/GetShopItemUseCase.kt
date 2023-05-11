package com.example.shoplist.domain.use_cases

import com.example.shoplist.domain.models.ShopItem
import com.example.shoplist.domain.repositories.ShopListRepository

class GetShopItemUseCase(
    private val shopListRepository: ShopListRepository
) {

    suspend fun getShopItem(shopItemId: Int): ShopItem {
        return  shopListRepository.getShopItem(shopItemId)
    }
}
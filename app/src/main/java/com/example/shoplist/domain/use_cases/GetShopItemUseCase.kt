package com.example.shoplist.domain.use_cases

import com.example.shoplist.domain.models.ShopItem
import com.example.shoplist.domain.repositories.ShopListRepository

class GetShopItemUseCase(
    val shopListRepository: ShopListRepository
) {

    fun getShopItem(ShopItemId: Int): ShopItem {
        return  shopListRepository.getShopItem(ShopItemId)
    }
}
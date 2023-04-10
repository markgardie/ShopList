package com.example.shoplist.domain.use_cases

import com.example.shoplist.domain.models.ShopItem
import com.example.shoplist.domain.repositories.ShopListRepository

class GetShopListUseCase(
    val shopListRepository: ShopListRepository
) {

    fun getShopList(): List<ShopItem> {
        return  shopListRepository.getShopList()
    }
}
package com.example.shoplist.domain.models

data class ShopItem(
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)

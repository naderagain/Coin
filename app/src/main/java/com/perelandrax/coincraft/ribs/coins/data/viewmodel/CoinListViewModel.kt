package com.perelandrax.coincraft.ribs.coins.data.viewmodel

data class CoinListViewModel(
  var id: String?,
  val imageUrl: String?,
  val name: String?,
  val coinName: String?,
  val percentage: String?,
  val price: String?,
  val volume: String?,
  val sortOrder: String?
)
package com.perelandrax.coinspace.framework.remote.api

import com.perelandrax.coinspace.framework.remote.model.coinsnapshot.CoinSnapshotFull
import com.perelandrax.coinspace.framework.remote.model.crytocompare.CrytoCompareCoinInfo
import com.perelandrax.coinspace.framework.remote.model.MarketCapCoin
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {

  companion object {

    fun create(baseUrl: String, okHttpClient: OkHttpClient): CoinApi {
      val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()
      return retrofit.create(CoinApi::class.java)
    }
  }

  @GET("/v1/ticker/?limit=0")
  suspend fun getMarketCapCoinList(): List<MarketCapCoin>

  @GET("/data/all/coinlist")
  suspend fun getCrytoCompareCoinList(): CrytoCompareCoinInfo

  @GET("/api/data/coinsnapshotfullbyid")
  suspend fun getCoinSnapshotFull(@Query("id") id: String): CoinSnapshotFull
}
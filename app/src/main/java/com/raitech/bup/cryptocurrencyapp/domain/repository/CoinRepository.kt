package com.raitech.bup.cryptocurrencyapp.domain.repository

import com.raitech.bup.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.raitech.bup.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}
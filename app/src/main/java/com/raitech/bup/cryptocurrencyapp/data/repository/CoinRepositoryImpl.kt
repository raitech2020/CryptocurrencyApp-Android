package com.raitech.bup.cryptocurrencyapp.data.repository

import com.raitech.bup.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.raitech.bup.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.raitech.bup.cryptocurrencyapp.data.remote.dto.CoinDto
import com.raitech.bup.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}
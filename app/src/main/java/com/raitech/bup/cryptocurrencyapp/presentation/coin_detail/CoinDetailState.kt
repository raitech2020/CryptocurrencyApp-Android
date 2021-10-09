package com.raitech.bup.cryptocurrencyapp.presentation.coin_detail

import com.raitech.bup.cryptocurrencyapp.domain.model.Coin
import com.raitech.bup.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

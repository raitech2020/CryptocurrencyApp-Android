package com.raitech.bup.cryptocurrencyapp.presentation.coin_list

import com.raitech.bup.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

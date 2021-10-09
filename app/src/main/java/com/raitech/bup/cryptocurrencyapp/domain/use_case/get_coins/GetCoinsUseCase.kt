package com.raitech.bup.cryptocurrencyapp.domain.use_case.get_coins

import com.raitech.bup.cryptocurrencyapp.common.Resource
import com.raitech.bup.cryptocurrencyapp.data.remote.dto.toCoin
import com.raitech.bup.cryptocurrencyapp.domain.model.Coin
import com.raitech.bup.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Internet connection error"))
        }
    }
}
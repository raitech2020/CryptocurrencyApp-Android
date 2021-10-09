package com.raitech.bup.cryptocurrencyapp.domain.use_case.get_coin

import com.raitech.bup.cryptocurrencyapp.common.Resource
import com.raitech.bup.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.raitech.bup.cryptocurrencyapp.domain.model.CoinDetail
import com.raitech.bup.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Internet connection error"))
        }
    }
}
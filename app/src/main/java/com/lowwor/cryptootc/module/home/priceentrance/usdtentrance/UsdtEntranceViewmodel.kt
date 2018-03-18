package com.lowwor.cryptootc.module.home.priceentrance.usdtentrance

import android.arch.lifecycle.MutableLiveData
import com.lowwor.cryptootc.base.BaseViewModel
import com.lowwor.cryptootc.data.api.CryptoOtcApi
import com.lowwor.cryptootc.data.model.price.EntrancePrice
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by lowwor on 2018/1/31.
 */
class UsdtEntranceViewmodel @Inject constructor(
        private val api: CryptoOtcApi
) : BaseViewModel() {
    val entrancePrices = MutableLiveData<List<EntrancePrice>>()

    init {
        updatePrices()
    }


    fun updatePrices() {
        disposables += api.getUsdtPrices().subscribe({
            Timber.d(it.toString())
            entrancePrices.value = it
        }, { it.printStackTrace() })
    }
}
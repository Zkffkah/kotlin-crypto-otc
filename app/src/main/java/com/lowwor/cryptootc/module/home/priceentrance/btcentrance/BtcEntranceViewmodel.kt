package com.lowwor.cryptootc.module.home.priceentrance.btcentrance

import android.arch.lifecycle.MutableLiveData
import com.lowwor.cryptootc.base.BaseViewModel
import com.lowwor.cryptootc.data.api.CryptoOtcApi
import com.lowwor.cryptootc.data.model.price.EntrancePrice
import com.lowwor.cryptootc.util.SingleLiveEvent
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by lowwor on 2018/1/31.
 */
class BtcEntranceViewmodel @Inject constructor(
        private val api: CryptoOtcApi
) : BaseViewModel() {
    val entrancePrices = MutableLiveData<List<EntrancePrice>>()
    val refreshStatus = SingleLiveEvent<Unit>()

    init {
        refreshStatus.call()
        updatePrices()
    }


    fun updatePrices() {
        disposables += api.getBtcPrices().subscribe({
            Timber.d(it.toString())
            entrancePrices.value = it
        }, { it.printStackTrace() })
    }
}
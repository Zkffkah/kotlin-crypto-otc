package com.lowwor.cryptootc.data.mapper

import com.lowwor.cryptootc.data.model.price.EntrancePrice
import com.lowwor.cryptootc.data.model.price.LocalBitcoinOtcBtcPrice
import com.lowwor.cryptootc.data.model.response.LocalBitcoinOtcRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object LocalBitcoinMapper {
    fun convertToOneStepBtcEntrancePrice(localBitcoinOtcRsp: LocalBitcoinOtcRsp): EntrancePrice =
            LocalBitcoinOtcBtcPrice(localBitcoinOtcRsp.pageData?.adList?.get(0)?.adData?.tempPrice?.toFloat())
}
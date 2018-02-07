package com.lowwor.bestentrance.data.mapper

import com.lowwor.bestentrance.data.model.price.EntrancePrice
import com.lowwor.bestentrance.data.model.price.LocalBitcoinOtcBtcPrice
import com.lowwor.bestentrance.data.model.response.LocalBitcoinOtcRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object LocalBitcoinMapper {
    fun convertToOneStepBtcEntrancePrice(localBitcoinOtcRsp: LocalBitcoinOtcRsp): EntrancePrice =
            LocalBitcoinOtcBtcPrice(localBitcoinOtcRsp.pageData?.adList?.get(0)?.adData?.tempPrice?.toFloat())
}
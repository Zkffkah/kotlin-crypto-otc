package com.lowwor.bestentrance.data.mapper

import com.lowwor.bestentrance.data.model.price.EntrancePrice
import com.lowwor.bestentrance.data.model.price.GankOtcUsdtPrice
import com.lowwor.bestentrance.data.model.response.GankOtcRsp

/**
 * Created by lowwor on 2018/1/24.
 */

object GankMapper {

    fun convertToEntrancePrice(gankOtcRsp: GankOtcRsp): EntrancePrice =
            GankOtcUsdtPrice(gankOtcRsp.appraisedRates?.buyRate?.toFloat())


}
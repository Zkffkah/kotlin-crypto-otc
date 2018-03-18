package com.lowwor.cryptootc.data.mapper

import com.lowwor.cryptootc.data.model.price.EntrancePrice
import com.lowwor.cryptootc.data.model.price.OtcbtcOtcBtcPrice
import com.lowwor.cryptootc.data.model.price.OtcbtcUsdtPrice
import com.lowwor.cryptootc.data.model.response.OtcbtcPriceRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object OtcbtcMapper {

    fun convertToOneStepUsdtEntrancePrice(otcbtcPriceRsp: OtcbtcPriceRsp): EntrancePrice =
            OtcbtcUsdtPrice(otcbtcPriceRsp.data[0].price)

    fun convertToOneStepBtcEntrancePrice(otcbtcPriceRsp: OtcbtcPriceRsp): EntrancePrice =
            OtcbtcOtcBtcPrice(otcbtcPriceRsp.data[0].price)

}
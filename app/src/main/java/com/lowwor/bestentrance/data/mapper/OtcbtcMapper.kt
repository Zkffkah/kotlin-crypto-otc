package com.lowwor.bestentrance.data.mapper

import com.lowwor.bestentrance.data.model.price.EntrancePrice
import com.lowwor.bestentrance.data.model.price.OtcbtcOtcBtcPrice
import com.lowwor.bestentrance.data.model.price.OtcbtcUsdtPrice
import com.lowwor.bestentrance.data.model.response.OtcbtcPriceRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object OtcbtcMapper {

    fun convertToOneStepUsdtEntrancePrice(otcbtcPriceRsp: OtcbtcPriceRsp): EntrancePrice =
            OtcbtcUsdtPrice(otcbtcPriceRsp.data[0].price)

    fun convertToOneStepBtcEntrancePrice(otcbtcPriceRsp: OtcbtcPriceRsp): EntrancePrice =
            OtcbtcOtcBtcPrice(otcbtcPriceRsp.data[0].price)

}
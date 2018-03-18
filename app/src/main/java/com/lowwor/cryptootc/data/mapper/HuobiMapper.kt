package com.lowwor.cryptootc.data.mapper

import com.lowwor.cryptootc.data.model.price.EntrancePrice
import com.lowwor.cryptootc.data.model.price.HuobiOtcBtcPrice
import com.lowwor.cryptootc.data.model.price.HuobiOtcUsdtBtcPrice
import com.lowwor.cryptootc.data.model.price.HuobiOtcUsdtPrice
import com.lowwor.cryptootc.data.model.response.HuobiOtcRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object HuobiMapper {

    fun convertToTwoStepBtcToEntrancePrice(price: Float): EntrancePrice =
            HuobiOtcUsdtBtcPrice(price)

    fun convertToOneStepBtcEntrancePrice(huobiOtcRsp: HuobiOtcRsp): EntrancePrice =
            HuobiOtcBtcPrice(huobiOtcRsp.data[0].price)

    fun convertToOneStepUsdtEntrancePrice(huobiOtcRsp: HuobiOtcRsp): EntrancePrice =
            HuobiOtcUsdtPrice(huobiOtcRsp.data[0].price)


}
package com.lowwor.cryptootc.data.mapper

import com.lowwor.cryptootc.data.model.price.EntrancePrice
import com.lowwor.cryptootc.data.model.price.ZbQcBtcPrice
import com.lowwor.cryptootc.data.model.response.ZbTickerRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object ZbMapper {

    fun convertToQcBtcEntrancePrice(zbTickerRsp: ZbTickerRsp): EntrancePrice =
            ZbQcBtcPrice(zbTickerRsp.ticker.last.toFloat())

}
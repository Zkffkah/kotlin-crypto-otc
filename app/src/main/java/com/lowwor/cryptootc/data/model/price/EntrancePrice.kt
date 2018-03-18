package com.lowwor.cryptootc.data.model.price

/**
 * Created by lowwor on 2018/1/24.
 */


const val HUOBI_NAME = "huobi.pro"
const val GANK_NAME = "gank.io"
const val OTCBTC_NAME = "otcbtc.com"
const val ZB_NAME = "zb.com"
const val LOCALBITCOINS_NAME = "localbitcoins.com"

sealed class EntrancePrice {
    abstract val price: Float?
    abstract val name: String?
    abstract val step: String?
}

data class HuobiOtcUsdtPrice(override val price: Float?,
                             override val name: String? = HUOBI_NAME,
                             override val step: String? = "cny -> usdt") : EntrancePrice()

data class HuobiOtcUsdtBtcPrice(override val price: Float?,
                                override val name: String? = HUOBI_NAME,
                                override val step: String? = "cny -> usdt \n usdt -> btc"
) : EntrancePrice()

data class GankOtcUsdtPrice(override val price: Float?,
                            override val name: String = GANK_NAME,
                            override val step: String? = "cny -> usdt") : EntrancePrice()

data class GankOtcUsdtBtcPrice(override val price: Float?,
                               override val name: String = GANK_NAME,
                               override val step: String? = "cny -> usdt \n usdt -> btc") : EntrancePrice()

data class OtcbtcUsdtPrice(override val price: Float?,
                           override val name: String = OTCBTC_NAME,
                           override val step: String? = "cny -> usdt") : EntrancePrice()

data class HuobiOtcBtcPrice(override val price: Float?,
                            override val name: String = HUOBI_NAME,
                            override val step: String? = "cny -> btc") : EntrancePrice()

data class ZbQcBtcPrice(override val price: Float?,
                        override val name: String = ZB_NAME,
                        override val step: String? = "cny -> qc \n qc -> btc") : EntrancePrice()

data class OtcbtcOtcBtcPrice(override val price: Float?,
                             override val name: String = OTCBTC_NAME,
                             override val step: String? = "cny -> btc") : EntrancePrice()

data class LocalBitcoinOtcBtcPrice(override val price: Float?,
                                   override val name: String = LOCALBITCOINS_NAME,
                                   override val step: String? = "cny -> btc") : EntrancePrice()




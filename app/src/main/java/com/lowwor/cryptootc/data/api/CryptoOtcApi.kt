package com.lowwor.cryptootc.data.api

import com.lowwor.cryptootc.data.mapper.*
import com.lowwor.cryptootc.data.model.price.EntrancePrice
import com.lowwor.cryptootc.data.model.response.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables.zip
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by lowwor on 2018/1/23.
 */
@Singleton
class CryptoOtcApi @Inject constructor(private val cryptoOtcService: CryptoOtcService) {


    fun getUsdtPrices(): Observable<List<EntrancePrice>> {
        return zip(getGankOtcUsdt(), getHuobiOtcUsdt(),
                getOtcbtcOtcUsdt(), { gankPriceRsp, huoBiPriceRsp, otcbtcPriceRsp ->


            listOf(GankMapper.convertToOneStepUsdtEntrancePrice(gankPriceRsp),
                    HuobiMapper.convertToOneStepUsdtEntrancePrice(huoBiPriceRsp),
                    OtcbtcMapper.convertToOneStepUsdtEntrancePrice(otcbtcPriceRsp)
            )
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun getBtcPrices(): Observable<List<EntrancePrice>> {
        return zip(getHuobiOtcUsdt().flatMap<Float> { huobiOtcUsdtRsp ->
            return@flatMap getHuobiTickerBtc().map {
                (huobiOtcUsdtRsp.data[0].price * it.tick.data[0].price).toFloat()
            }
        },
                getGankOtcUsdt().flatMap { gankOtcRsp ->
                    return@flatMap getGankTickerBtc().map { gankTickerBtcRsp ->
                        (gankTickerBtcRsp.last * gankOtcRsp.appraisedRates?.buyRate!!.toDouble()).toFloat()
                    }
                },
                getHuobiOtcBtc(), getOtcbtcOtcBtc(),
                getZbTickerBtc(), getLocalBitcoinOtcBtc(), { huobiTwoStepBtcPrice, gankTwoStepBtcPrice, huoBiPriceRsp, otcbtcPriceRsp, zbPriceRsp,
                                                             localBitcoinsPriceRsp ->

            listOf(HuobiMapper.convertToTwoStepBtcToEntrancePrice(huobiTwoStepBtcPrice),
                    HuobiMapper.convertToOneStepBtcEntrancePrice(huoBiPriceRsp),
                    GankMapper.convertToTwoStepBtcEntrancePrice(gankTwoStepBtcPrice),
                    OtcbtcMapper.convertToOneStepBtcEntrancePrice(otcbtcPriceRsp),
                    ZbMapper.convertToQcBtcEntrancePrice(zbPriceRsp),
                    LocalBitcoinMapper.convertToOneStepBtcEntrancePrice(localBitcoinsPriceRsp)
            )
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }


    private fun getHuobiOtcUsdt(): Observable<HuobiOtcRsp> =
            cryptoOtcService.getHuobiOtcPrice(HUOBI_OTC_COIN_ID_USDT)

    private fun getHuobiTickerBtc(): Observable<HuobiTickerRsp> =
            cryptoOtcService.getHuobiTickerPrice(HUOBI_TICKER_BTC_USDT)

    private fun getHuobiOtcBtc(): Observable<HuobiOtcRsp> =
            cryptoOtcService.getHuobiOtcPrice(HUOBI_OTC_COIN_ID_BTC)

    private fun getOtcbtcOtcUsdt(): Observable<OtcbtcPriceRsp> =
            cryptoOtcService.getOtcbtcOtcPrice(OTCBTC_OTC_CURRENCY_USDT)

    private fun getOtcbtcOtcBtc(): Observable<OtcbtcPriceRsp> =
            cryptoOtcService.getOtcbtcOtcPrice(OTCBTC_OTC_CURRENCY_BTC)

    private fun getZbTickerBtc(): Observable<ZbTickerRsp> =
            cryptoOtcService.getZbTickerPrice(ZB_TICKER_BTC_QC)

    private fun getGankOtcUsdt(): Observable<GankOtcRsp> =
            cryptoOtcService.getGankOtcUsdtPrice(GANK_OTC_SYMBOL_USDT)

    private fun getGankTickerBtc(): Observable<GankTickerRsp> =
            cryptoOtcService.getGankTickerPrice(GANK_TICKER_BTC_USDT)

    private fun getLocalBitcoinOtcBtc(): Observable<LocalBitcoinOtcRsp> =
            cryptoOtcService.getLocalBitcoinOtcPrice()


}
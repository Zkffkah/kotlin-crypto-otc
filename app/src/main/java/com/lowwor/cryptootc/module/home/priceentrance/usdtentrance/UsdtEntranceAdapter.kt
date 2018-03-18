package com.lowwor.cryptootc.module.home.priceentrance.usdtentrance

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lowwor.cryptootc.R
import com.lowwor.cryptootc.data.model.price.EntrancePrice

/**
 * Created by lowwor on 2018/1/31.
 */
class UsdtEntranceAdapter : BaseQuickAdapter<EntrancePrice, BaseViewHolder>(R.layout.item_entrance_price) {

    override fun convert(helper: BaseViewHolder, item: EntrancePrice) {

        helper.setText(R.id.text_market_name, item.name)
        helper.setText(R.id.text_price, item.price.toString())
    }


}
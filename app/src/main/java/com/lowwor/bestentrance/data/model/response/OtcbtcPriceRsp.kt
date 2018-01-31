package com.lowwor.bestentrance.data.model.response

import org.jsoup.nodes.Element
import pl.droidsonroids.jspoon.ElementConverter
import pl.droidsonroids.jspoon.annotation.Selector


/**
 * Created by lowwor on 2018/1/23.
 */

class OtcbtcPriceRsp {
    @Selector(".list-content") lateinit var data: List<OtcbtcPriceItem>
}

class OtcbtcPriceItem {
    @Selector(value = ".price", converter = OtcbtcPriceConverter::class)
    var price: Float = 0F
}

private class OtcbtcPriceConverter : ElementConverter<Float> {

    override fun convert(node: Element, selector: Selector): Float {
        var text = node.select(selector.value)[0].ownText().replace(",", "")
        return text.toFloat()
    }
}


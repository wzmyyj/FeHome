package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendLinkGoodsModel(

    var txt: String = "商品链接"

) : ITrendModelType {

    override fun getViewType() = R.layout.trend_link_goods

}
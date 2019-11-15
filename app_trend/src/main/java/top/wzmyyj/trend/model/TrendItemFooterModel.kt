package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendItemFooterModel(

    var txt: String = "列表底部"

) : ITrendModelType {

    override fun getViewType() = R.layout.trend_item_footer

}
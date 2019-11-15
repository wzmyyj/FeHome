package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendItemHeaderModel(

    var txt: String = "列表头部"

) : ITrendModelType {

    override fun getViewType() = R.layout.trend_item_header

    interface OnItemEventListener {
        fun onHeader(model: TrendItemHeaderModel)
    }
}
package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendItemEmptyModel(

    var txt: String = "空数据"

) : ITrendModelType {

    override fun getViewType() = R.layout.trend_item_empty

    interface OnItemEventListener {
        fun onEmpty(model: TrendItemEmptyModel)
    }
}
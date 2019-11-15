package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendUserItemModel(

    var txt: String = "用户"

) : IUserModelType {

    override fun getViewType() = R.layout.trend_user_item

    interface OnItemListener {
        fun onUserClick(model: TrendUserItemModel)
    }
}
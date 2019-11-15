package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendLinkExhibitionModel(

    var txt: String = "会场链接"

) : ITrendModelType {

    override fun getViewType(): Int {
        return R.layout.trend_link_exhibition
    }
}
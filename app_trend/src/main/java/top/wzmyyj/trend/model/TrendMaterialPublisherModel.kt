package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendMaterialPublisherModel(

    var txt: String = "发布者，素材头部"

) : ITrendModelType {

    override fun getViewType() = R.layout.trend_material_publisher
}
package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendMaterialPic2Model(

    var txt: String = ""

) : ITrendModelType {

    override fun getViewType() = R.layout.trend_material_pic2
}
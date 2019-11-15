package top.wzmyyj.trend.model

import top.wzmyyj.trend.R

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendMaterialTextModel(

    var txt: String = "文本内容: 哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"

) : ITrendModelType {

    override fun getViewType() = R.layout.trend_material_text
}
package top.wzmyyj.trend.model

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendMaterialPicModelWrapper(

    var pic2List: List<TrendMaterialPic2Model>? = null,
    var pic3List: List<TrendMaterialPic3Model>? = null

) : ITrendModelType {

    override fun getViewType() = 0

    override fun getChildren() = ArrayList<ITrendModelType>().also { list ->
        pic2List?.let {
            list.addAll(it)
        }
        pic3List?.let {
            list.addAll(it)
        }
    }
}
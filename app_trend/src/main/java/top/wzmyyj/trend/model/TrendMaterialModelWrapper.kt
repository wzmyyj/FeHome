package top.wzmyyj.trend.model

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendMaterialModelWrapper(

    var publisher: TrendMaterialPublisherModel? = null,
    var text: TrendMaterialTextModel? = null,
    var pic: TrendMaterialPicModelWrapper? = null,
    var link: TrendLinkModelWrapper? = null,
    var bottom: TrendMaterialBottomModel? = null

) : ITrendModelType {

    override fun getViewType()=0

    override fun getChildren()=ArrayList<ITrendModelType>().also {list->
        publisher?.let {
            list.add(it)
        }
        text?.let {
            list.add(it)
        }
        pic?.let {
            list.add(it)
        }
        link?.let {
            list.add(it)
        }
        bottom?.let {
            list.add(it)
        }
    }
}
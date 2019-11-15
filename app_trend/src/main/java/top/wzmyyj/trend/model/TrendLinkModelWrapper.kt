package top.wzmyyj.trend.model

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendLinkModelWrapper(

    var linkGoods: TrendLinkGoodsModel? = null,
    var linkMeeting: TrendLinkExhibitionModel? = null

) : ITrendModelType {

    override fun getViewType() = 0

    override fun getChildren() = ArrayList<ITrendModelType>().also { list ->
        linkGoods?.let {
            list.add(it)
        }
        linkMeeting?.let {
            list.add(it)
        }
    }
}
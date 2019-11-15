package top.wzmyyj.trend.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import top.wzmyyj.common.base.CBaseViewModel
import top.wzmyyj.common.utils.noMutable
import top.wzmyyj.trend.model.*

/**
 * Created on 2019/11/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

class TrendViewModel(application: Application) : CBaseViewModel(application) {


    private val _listLiveData = MutableLiveData<List<ITrendModelType>>()
    val listLiveData = _listLiveData.noMutable()

    fun getData() {
        val head = TrendItemHeaderModel()
        val foot = TrendItemFooterModel()
        val empty = TrendItemEmptyModel()


        val publisher = TrendMaterialPublisherModel()
        val text = TrendMaterialTextModel()
        val pic = TrendMaterialPicModelWrapper()
        val link = TrendLinkModelWrapper()
        val bottom = TrendMaterialBottomModel()


        val material = TrendMaterialModelWrapper()
        material.publisher = publisher
        material.text = text
        material.pic = pic
        material.link = link
        material.bottom = bottom


        val pic2List = ArrayList<TrendMaterialPic2Model>()
        val pic2 = TrendMaterialPic2Model()
        pic2List.add(pic2)
        pic2List.add(pic2)

        //或者
//        val pic3List = ArrayList<TrendMaterialPic3Model>()
//        val pic3 = TrendMaterialPic3Model()
//        pic3List.add(pic3)
//        pic3List.add(pic3)
//        pic3List.add(pic3)


        pic.pic2List = pic2List

        val linkGoods = TrendLinkGoodsModel()
        link.linkGoods = linkGoods

        //或者
//        val linkMeeting = TrendLinkExhibitionModel()
//        link.linkMeeting = linkMeeting


        val userList = TrendUserListModel()

        val users = ArrayList<TrendUserItemModel>()
        users.add(TrendUserItemModel())
        users.add(TrendUserItemModel())
        users.add(TrendUserItemModel())
        users.add(TrendUserItemModel())
        users.add(TrendUserItemModel())
        users.add(TrendUserItemModel())
        userList.list.clear()
        userList.list.addAll(users)

        val list = ArrayList<ITrendModelType>()
        list.add(head)
        list.add(userList)
        list.add(material)
        list.add(material)
        list.add(material)
        list.add(empty)
        list.add(foot)
        _listLiveData.value=list
    }
}
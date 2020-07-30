package top.wzmyyj.active.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import top.wzmyyj.active.model.ActivePathModel
import top.wzmyyj.active.model.ActiveSingleModel
import top.wzmyyj.active.model.IActiveModelType
import top.wzmyyj.common.base.CBaseViewModel
import top.wzmyyj.common.utils.noMutable
import top.wzmyyj.common_service.ActivityPath

/**
 * Created on 2019/11/14.
 *
 * @author feling
 * @version 1.0.1
 * @since 1.0.0
 */

class ActiveViewModel(application: Application) : CBaseViewModel(application) {


    private val _listLiveData = MutableLiveData<List<IActiveModelType>>()
    val listLiveData = _listLiveData.noMutable()

    fun getData() {
        val list = ArrayList<IActiveModelType>()
        list.add(
            ActivePathModel(
                title = "Adapter实验",
                path = ActivityPath.TREND
            )
        )
        list.add(
            ActiveSingleModel(
                title = "Toast实验",
                action = 1,
                desc = "这是一条Toast！"
            )
        )
        list.add(
            ActiveSingleModel(
                title = "pt实验",
                action = 2,
                desc = "这个是pt实验！"
            )
        )
        list.add(
            ActivePathModel(
                title = "WorkManager实验",
                path = ActivityPath.ACTIVE,
                target = "work"
            )
        )
        _listLiveData.value = list
    }
}
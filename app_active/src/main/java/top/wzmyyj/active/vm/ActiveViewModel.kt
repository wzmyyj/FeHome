package top.wzmyyj.active.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import top.wzmyyj.active.model.ActiveItemModel
import top.wzmyyj.active.model.IActiveModelType
import top.wzmyyj.common.base.CBaseViewModel
import top.wzmyyj.common.utils.noMutable
import top.wzmyyj.common_service.ActivityPath

/**
 * Created on 2019/11/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

class ActiveViewModel(application: Application) : CBaseViewModel(application) {


    private val _listLiveData = MutableLiveData<List<IActiveModelType>>()
    val listLiveData = _listLiveData.noMutable()

    fun getData() {
        val list = ArrayList<IActiveModelType>()
        val model = ActiveItemModel(path = ActivityPath.TREND,desc = "Adapter实验")
        list.add(model)
        _listLiveData.value = list
    }
}
package top.wzmyyj.common.base

import android.app.Application
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.MediatorLiveData
import top.wzmyyj.base.viewmodel.BaseViewModel
import top.wzmyyj.common.utils.noMutable

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class CBaseViewModel(application: Application) :
    BaseViewModel(application), DefaultLifecycleObserver {

    private val _toast = MediatorLiveData<String>()
    val toast = _toast.noMutable()


    fun showToast(msg: String?) {
        _toast.postValue(msg)
    }
}
package top.wzmyyj.common.base

import androidx.lifecycle.Observer
import top.wzmyyj.base.activity.BaseActivity
import top.wzmyyj.utils.tools.ToastUtil

/**
 * Created on 2019/09/29.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class CBaseActivity : BaseActivity() {


    protected open fun <T : CBaseViewModel> createViewModel(vmClass: Class<T>): T {
        return getViewModel(vmClass).apply { initVm(this) }
    }

    private var isFirstUseVm = true

    private fun <T : CBaseViewModel> initVm(vm: T) {
        if (!isFirstUseVm) return
        observerVm(vm)
        isFirstUseVm = false
    }

    protected open fun <T : CBaseViewModel> observerVm(vm: T) {
        this.lifecycle.addObserver(vm)
        vm.toast.observe(this, Observer { showToast(it) })
    }


    protected open fun showToast(msg: String?) {
        ToastUtil.show(this, msg)
    }
}
package top.wzmyyj.common.base

import androidx.lifecycle.Observer
import top.wzmyyj.base.fragment.BaseFragment
import top.wzmyyj.utils.tools.ToastUtil

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class CBaseFragment : BaseFragment() {


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
        ToastUtil.show(context ?: return, msg)
    }


}
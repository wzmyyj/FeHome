package top.wzmyyj.common.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import top.wzmyyj.utils.app.ContextUtil
import top.wzmyyj.utils.app.FragmentUtil
import top.wzmyyj.utils.tools.ToastUtil

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * @param containerId .
 * @param fragment .
 * @param isAddToBackStack 将要替换的fragment是否要添加到返回栈
 * @param tag TAG
 */
fun FragmentManager.addFragment(
    containerId: Int, fragment: Fragment,
    isAddToBackStack: Boolean = false, tag: String? = null
) {
    FragmentUtil.addFragment(this, containerId, fragment, isAddToBackStack, tag)
}

/**
 * @param containerId .
 * @param fragment .
 * @param isAddToBackStack 将要替换的fragment是否要添加到返回栈
 * @param tag TAG
 */
fun FragmentManager.replaceFragment(
    containerId: Int, fragment: Fragment,
    isAddToBackStack: Boolean = false, tag: String? = null
) {
    FragmentUtil.replaceFragment(this, containerId, fragment, isAddToBackStack, tag)

}


fun FragmentActivity.addFragment(
    containerId: Int, fragment: Fragment,
    isAddToBackStack: Boolean = false, tag: String? = null
) {
    supportFragmentManager.addFragment(containerId, fragment, isAddToBackStack, tag)
}

fun FragmentActivity.replaceFragment(
    containerId: Int, fragment: Fragment,
    isAddToBackStack: Boolean = false, tag: String? = null
) {
    supportFragmentManager.addFragment(containerId, fragment, isAddToBackStack, tag)
}

fun Fragment.addFragment(
    containerId: Int, fragment: Fragment,
    isAddToBackStack: Boolean = false, tag: String? = null
) {
    childFragmentManager.addFragment(containerId, fragment, isAddToBackStack, tag)
}

fun Fragment.replaceFragment(
    containerId: Int, fragment: Fragment,
    isAddToBackStack: Boolean = false, tag: String? = null
) {
    childFragmentManager.replaceFragment(containerId, fragment, isAddToBackStack, tag)
}


fun <T : CBaseViewModel> FragmentActivity.getViewModel(modelClass: Class<T>): T {
    return ViewModelProviders.of(this).get(modelClass)
}

fun <T : CBaseViewModel> Fragment.getViewModel(modelClass: Class<T>): T {
    return ViewModelProviders.of(this).get(modelClass)
}

fun <T : CBaseViewModel> Fragment.getViewModelOfParent(modelClass: Class<T>): T? {
    return ViewModelProviders.of(parentFragment ?: return null).get(modelClass)

}

fun <T : CBaseViewModel> Fragment.getViewModelOfActivity(modelClass: Class<T>): T? {
    return ViewModelProviders.of(activity ?: return null).get(modelClass)
}

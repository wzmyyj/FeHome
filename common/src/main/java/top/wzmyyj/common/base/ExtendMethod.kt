package top.wzmyyj.common.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import top.wzmyyj.utils.app.FragmentUtil

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
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
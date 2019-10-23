package top.wzmyyj.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common_service.ModulePath
import top.wzmyyj.kit.helper.PagerTabManager
import top.wzmyyj.kit.helper.PagerTabHelper
import top.wzmyyj.main.R


/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class MainFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val helper: PagerTabHelper by lazy {
        object : PagerTabHelper() {
            override fun init(manager: PagerTabManager) {
                setTextSelectColor(manager)
                addHomeFragment(manager)
                addActiveFragment(manager)
                addMessageFragment(manager)
                addMineFragment(manager)
            }
        }
    }


    private fun setTextSelectColor(manager: PagerTabManager) {
        manager.setSelectColor(getColor(R.color.colorPrimary))
        manager.setUnSelectColor(getColor(R.color.colorGray_9))
    }


    private fun addHomeFragment(manager: PagerTabManager) {
        val fragment = ARouter
            .getInstance()
            .build(ModulePath.MAIN_HOME)
            .navigation() as? Fragment ?: return

        manager.add(
            fragment, getString(R.string.main_home),
            getDrawable(R.drawable.main_selector_home)!!
        )
    }

    private fun addActiveFragment(manager: PagerTabManager) {
        val fragment = ARouter
            .getInstance()
            .build(ModulePath.MAIN_ACTIVE)
            .navigation() as? Fragment ?: return

        manager.add(
            fragment, getString(R.string.main_active),
            getDrawable(R.drawable.main_selector_active)!!
        )
    }

    private fun addMessageFragment(manager: PagerTabManager) {
        val fragment = ARouter
            .getInstance()
            .build(ModulePath.MAIN_MESSAGE)
            .navigation() as? Fragment ?: return

        manager.add(
            fragment, getString(R.string.main_message),
            getDrawable(R.drawable.main_selector_message)!!
        )
    }

    private fun addMineFragment(manager: PagerTabManager) {
        val fragment = ARouter
            .getInstance()
            .build(ModulePath.MAIN_MINE)
            .navigation() as? Fragment ?: return

        manager.add(
            fragment, getString(R.string.main_mine),
            getDrawable(R.drawable.main_selector_mine)!!
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return helper.getView(requireContext(), childFragmentManager, container)
    }
}
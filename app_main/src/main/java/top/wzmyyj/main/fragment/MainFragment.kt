package top.wzmyyj.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common_service.main_active.IMainActiveService
import top.wzmyyj.common_service.main_home.IMainHomeService
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
                setPagerTabManager(manager)
            }
        }
    }


    private fun setPagerTabManager(manager: PagerTabManager) {
        manager.add(
            getHomeFragment(),
            getString(R.string.main_home),
            getDrawable(R.drawable.main_selector_home)!!
        )

        manager.add(
            getActiveFragment(),
            getString(R.string.main_active),
            getDrawable(R.drawable.main_selector_active)!!
        )


        manager.add(
            MainMessageFragment.newInstance(),
            getString(R.string.main_message),
            getDrawable(R.drawable.main_selector_message)!!
        )

        manager.add(
            MainMineFragment.newInstance(),
            getString(R.string.main_mine),
            getDrawable(R.drawable.main_selector_mine)!!
        )

        manager.setSelectColor(getColor(R.color.colorPrimary))
        manager.setUnSelectColor(getColor(R.color.colorGray_9))
    }


    private fun getHomeFragment(): Fragment {
        val service = ARouter.getInstance().navigation(IMainHomeService::class.java)
        return service.getFragment()

    }


    private fun getActiveFragment(): Fragment {
        val service = ARouter.getInstance().navigation(IMainActiveService::class.java)
        return service.getFragment()

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return helper.getView(requireContext(), childFragmentManager, container)
    }
}
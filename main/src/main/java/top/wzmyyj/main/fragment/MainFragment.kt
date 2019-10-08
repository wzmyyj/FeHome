package top.wzmyyj.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.kit.helper.FragmentTabWrapper
import top.wzmyyj.kit.helper.PagerTabFragmentHelper
import top.wzmyyj.main.R

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class MainFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val helper: PagerTabFragmentHelper by lazy {
        object : PagerTabFragmentHelper() {
            override fun initFTs(wrapper: FragmentTabWrapper) {
                wrapper.add(
                    MainHomeFragment.newInstance(),
                    R.string.main_home,
                    R.drawable.main_ic_home_0,
                    R.drawable.main_ic_home_1
                )

                wrapper.add(
                    MainActiveFragment.newInstance(),
                    R.string.main_active,
                    R.drawable.main_ic_active_0,
                    R.drawable.main_ic_active_1
                )

                wrapper.add(
                    MainMessageFragment.newInstance(),
                    R.string.main_message,
                    R.drawable.main_ic_message_0,
                    R.drawable.main_ic_message_1
                )

                wrapper.add(
                    MainMineFragment.newInstance(),
                    R.string.main_mine,
                    R.drawable.main_ic_mine_0,
                    R.drawable.main_ic_mine_1
                )

                wrapper.setColorRes(R.color.colorGray_6, R.color.colorPrimary)

            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return helper.getView(requireContext(), childFragmentManager)
    }
}
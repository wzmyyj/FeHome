package top.wzmyyj.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import top.wzmyyj.common.base.CBaseFragment
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
                manager.add(
                    MainHomeFragment.newInstance(),
                    resources.getString(R.string.main_home),
                    resources.getDrawable(R.drawable.main_selector_home)
                )

                manager.add(
                    MainActiveFragment.newInstance(),
                    resources.getString(R.string.main_active),
                    resources.getDrawable(R.drawable.main_selector_active)
                )

                manager.add(
                    MainMessageFragment.newInstance(),
                    resources.getString(R.string.main_message),
                    resources.getDrawable(R.drawable.main_selector_message)
                )

                manager.add(
                    MainMineFragment.newInstance(),
                    resources.getString(R.string.main_mine),
                    resources.getDrawable(R.drawable.main_selector_mine)
                )

                manager.setSelectColor(ContextCompat.getColor(requireContext(),R.color.colorPrimary))
                manager.setUnSelectColor(ContextCompat.getColor(requireContext(),R.color.colorGray_9))

            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return helper.getView(requireContext(), childFragmentManager, container)
    }
}
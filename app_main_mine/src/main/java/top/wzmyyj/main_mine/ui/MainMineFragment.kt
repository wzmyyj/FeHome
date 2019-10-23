package top.wzmyyj.main_mine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common_service.ModulePath
import top.wzmyyj.main_mine.databinding.MainMineFragmentBinding

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ModulePath.MAIN_MINE, name = "主页我的模块Fragment")
class MainMineFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MainMineFragment()
    }

    private val binding by lazy {
        MainMineFragmentBinding.inflate(layoutInflater, null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}
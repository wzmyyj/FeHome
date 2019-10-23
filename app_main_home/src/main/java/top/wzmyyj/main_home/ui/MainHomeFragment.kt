package top.wzmyyj.main_home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common_service.ModulePath
import top.wzmyyj.main_home.databinding.MainHomeFragmentBinding

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ModulePath.MAIN_HOME, name = "主页首页模块Fragment")
class MainHomeFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MainHomeFragment()
    }

    private val binding by lazy {
        MainHomeFragmentBinding.inflate(layoutInflater, null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}
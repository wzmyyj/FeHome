package top.wzmyyj.main_active.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common_service.ModulePath
import top.wzmyyj.main_active.databinding.MainActiveFragmentBinding

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ModulePath.MAIN_ACTIVE, name = "主页活动模块Fragment")
class MainActiveFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MainActiveFragment()
    }

    private val binding by lazy {
        MainActiveFragmentBinding.inflate(layoutInflater, null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}
package top.wzmyyj.main_message.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common_service.ModulePath
import top.wzmyyj.main_message.databinding.MainMessageFragmentBinding

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ModulePath.MAIN_MESSAGE, name = "主页消息模块Fragment")
class MainMessageFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MainMessageFragment()
    }

    private val binding by lazy {
        MainMessageFragmentBinding.inflate(layoutInflater, null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.countDown.setEndTime(System.currentTimeMillis() + 10 * 60 * 1000L)
    }
}
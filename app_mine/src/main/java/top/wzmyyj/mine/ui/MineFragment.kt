package top.wzmyyj.mine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.mine.databinding.MineFragmentBinding

/**
 * Created on 2019/09/30.
 *
 * 我的模块Fragment
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class MineFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MineFragment()
    }

    private val binding by lazy {
        MineFragmentBinding.inflate(layoutInflater, null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}
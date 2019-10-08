package top.wzmyyj.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.main.databinding.MainMessageFragmentBinding

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
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
}
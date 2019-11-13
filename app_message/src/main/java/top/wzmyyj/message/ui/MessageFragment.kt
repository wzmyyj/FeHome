package top.wzmyyj.message.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.message.databinding.MessageFragmentBinding

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class MessageFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MessageFragment()
    }

    private val binding by lazy {
        MessageFragmentBinding.inflate(layoutInflater, null, false)
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
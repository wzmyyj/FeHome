package top.wzmyyj.active.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.active.databinding.ActiveFragmentBinding
import top.wzmyyj.active.model.ActiveItemModel
import top.wzmyyj.active.ui.adapter.ActiveAdapter
import top.wzmyyj.active.vm.ActiveViewModel
import top.wzmyyj.common.base.addToLifecycle
import top.wzmyyj.common.base.getViewModel
import top.wzmyyj.common_service.RouterManager

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class ActiveFragment : CBaseFragment() {

    companion object {
        fun newInstance() = ActiveFragment()
    }

    private val binding by lazy {
        ActiveFragmentBinding.inflate(layoutInflater, null, false)
    }

    private val vm by lazy {
        getViewModel(ActiveViewModel::class.java).addToLifecycle(lifecycle)
    }

    private val mAdapter by lazy {
        ActiveAdapter(listener)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    private val initOnce by lazy {
        initViewModel()
        initView()
        subscribeUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initOnce
    }


    private fun initViewModel() {

    }


    private fun initView() {
        binding.rv.adapter = mAdapter
    }

    private fun subscribeUI() {
        vm.listLiveData.observe(this, Observer {
            it?.run {
                mAdapter.setData(it)
            }
        })
        vm.getData()

    }


    private val listener = object : ActiveAdapter.OnAdapterListener {
        override fun onItemClick(model: ActiveItemModel) {
            RouterManager.goPage(model.path, model.target, model.params, "active")
        }
    }
}
package top.wzmyyj.active.ui

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import top.wzmyyj.active.ActiveActivity
import top.wzmyyj.active.PtActivity
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.active.databinding.ActiveFragmentBinding
import top.wzmyyj.active.model.ActivePathModel
import top.wzmyyj.active.model.ActiveSingleModel
import top.wzmyyj.active.ui.adapter.ActiveAdapter
import top.wzmyyj.active.utils.AdaptScreenUtil
import top.wzmyyj.active.vm.ActiveViewModel
import top.wzmyyj.common_service.RouterManager

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.1
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
        createViewModel(ActiveViewModel::class.java)
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
        override fun onPathClick(model: ActivePathModel) {
            RouterManager.goPage(model.path, model.target, model.params, "active")
        }

        override fun onSingleClick(model: ActiveSingleModel) {
            when (model.action) {
                1 -> {
                    vm.showToast(model.desc)
                    startActivity(Intent(context!!, ActiveActivity::class.java))
                }
                2 -> {
                    startActivity(Intent(context!!, PtActivity::class.java))
                }
            }
        }
    }
}
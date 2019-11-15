package top.wzmyyj.trend.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common.base.addToLifecycle
import top.wzmyyj.common.base.getViewModel
import top.wzmyyj.trend.ui.adapter.TrendAdapter
import top.wzmyyj.trend.databinding.TrendFragmentBinding
import top.wzmyyj.trend.model.*
import top.wzmyyj.trend.vm.TrendViewModel

/**
 * Created on 2019/11/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class TrendFragment : CBaseFragment() {


    companion object {
        fun newInstance() = TrendFragment()
    }


    private val binding by lazy {
        TrendFragmentBinding.inflate(layoutInflater)!!
    }

    private val vm by lazy {
        getViewModel(TrendViewModel::class.java).addToLifecycle(lifecycle)
    }

    private val mAdapter by lazy {
        TrendAdapter(listener)
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
            it?.let { mAdapter.setData(it) }
        })
        vm.getData()

    }


    private val listener = object : TrendAdapter.OnAdapterListener {
        override fun onUserClick(model: TrendUserItemModel) {
            Toast.makeText(activity, model.txt, Toast.LENGTH_SHORT).show()
        }

        override fun onHeader(model: TrendItemHeaderModel) {
            Toast.makeText(activity, model.txt, Toast.LENGTH_SHORT).show()
        }

        override fun onEmpty(model: TrendItemEmptyModel) {
            Toast.makeText(activity, model.txt, Toast.LENGTH_SHORT).show()
        }

    }


}
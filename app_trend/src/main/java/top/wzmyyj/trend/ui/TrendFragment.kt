package top.wzmyyj.trend.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import top.wzmyyj.common.base.CBaseFragment
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

    interface OnEventListener {
        fun add()

        fun mod()
    }


    private val binding by lazy {
        TrendFragmentBinding.inflate(layoutInflater)!!
    }

    private val vm by lazy {
        createViewModel(TrendViewModel::class.java)
    }

    private val mAdapter by lazy {
        TrendAdapter(adapterListener)
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
        binding.listener = eventListener
        binding.rv.adapter = mAdapter
    }

    private fun subscribeUI() {
        vm.listLiveData.observe(this, Observer {
            it?.let { mAdapter.submitList(it) }
        })
        vm.getData()

    }


    private val eventListener = object : OnEventListener {
        override fun add() {
            vm.add()
        }

        override fun mod() {
            vm.mod()
        }

    }


    private val adapterListener = object : TrendAdapter.OnAdapterListener {
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
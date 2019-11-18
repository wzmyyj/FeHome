package top.wzmyyj.trend.ui.adapter

import androidx.databinding.ViewDataBinding
import top.wzmyyj.adapter.tree.BaseTreeAdapter
import top.wzmyyj.adapter.base.ViewTypeDelegateManager
import top.wzmyyj.adapter.tree.BaseTreeDiffAdapter
import top.wzmyyj.trend.model.TrendItemEmptyModel
import top.wzmyyj.trend.model.TrendItemHeaderModel
import top.wzmyyj.trend.BR
import top.wzmyyj.trend.model.ITrendModelType

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendAdapter(private val listener: OnAdapterListener) : BaseTreeDiffAdapter<ITrendModelType>() {
    override fun onCreateVHForAll(binding: ViewDataBinding) {
        binding.setVariable(BR.listener, listener)
    }

    override fun onBindVHForAll(binding: ViewDataBinding, m: ITrendModelType) {
        binding.setVariable(BR.item, m)
    }


    override fun addDelegate(manager: ViewTypeDelegateManager<ITrendModelType>) {
        super.addDelegate(manager)
        manager.add(TrendUserListVTD(listener))
    }


    interface OnAdapterListener :
        TrendItemHeaderModel.OnItemEventListener,
        TrendItemEmptyModel.OnItemEventListener,
        TrendUserAdapter.OnAdapterListener
}
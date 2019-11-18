package top.wzmyyj.trend.ui.adapter

import androidx.databinding.ViewDataBinding
import top.wzmyyj.adapter.list.BaseListAdapter
import top.wzmyyj.trend.model.IUserModelType
import top.wzmyyj.trend.model.TrendUserItemModel
import top.wzmyyj.trend.BR

/**
 * Created on 2019/08/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendUserAdapter(private val listener: OnAdapterListener) :
    BaseListAdapter<IUserModelType>() {
    override fun onCreateVHForAll(binding: ViewDataBinding) {
        binding.setVariable(BR.listener, listener)
    }

    override fun onBindVHForAll(binding: ViewDataBinding, m: IUserModelType) {
        binding.setVariable(BR.item, m)
    }


    interface OnAdapterListener : TrendUserItemModel.OnItemListener
}
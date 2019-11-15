package top.wzmyyj.active.ui.adapter

import androidx.databinding.ViewDataBinding
import top.wzmyyj.active.BR
import top.wzmyyj.active.model.ActiveItemModel
import top.wzmyyj.active.model.IActiveModelType
import top.wzmyyj.adapter.base.BaseListAdapter

/**
 * Created on 2019/11/15.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class ActiveAdapter(private val listener: OnAdapterListener) : BaseListAdapter<IActiveModelType>() {
    override fun onCreateVHForAll(binding: ViewDataBinding) {
        binding.setVariable(BR.listener, listener)

    }

    override fun onBindVHForAll(binding: ViewDataBinding, m: IActiveModelType) {
        binding.setVariable(BR.item, m)
    }

    interface OnAdapterListener : ActiveItemModel.OnItemEventListener

}
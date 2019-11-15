package top.wzmyyj.trend.ui.adapter

import top.wzmyyj.adapter.base.ViewTypeDelegate
import top.wzmyyj.trend.R
import top.wzmyyj.trend.databinding.TrendUserListBinding
import top.wzmyyj.trend.model.TrendUserListModel

/**
 * Created on 2019/08/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
class TrendUserListVTD(private val listener: TrendUserAdapter.OnAdapterListener) :
    ViewTypeDelegate<TrendUserListBinding, TrendUserListModel> {

    override fun getViewType() = R.layout.trend_user_list

    override fun onCreateVH(binding: TrendUserListBinding) {
        binding.rv4.adapter = TrendUserAdapter(listener)
    }

    override fun onBindVH(binding: TrendUserListBinding, m: TrendUserListModel) {
        (binding.rv4.adapter as? TrendUserAdapter)?.setData(m.list)
    }

}
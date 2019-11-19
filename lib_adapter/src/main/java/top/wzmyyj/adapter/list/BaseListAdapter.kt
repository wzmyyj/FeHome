package top.wzmyyj.adapter.list

import top.wzmyyj.adapter.base.BaseAdapter
import top.wzmyyj.adapter.base.IModelType

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
abstract class BaseListAdapter<M : IModelType> : BaseAdapter<M>(), IMutableListData<M> {

    private val items: MutableList<M> = ArrayList()

    override fun list(): List<M> {
        return items
    }


    override fun getData(): MutableList<M> {
        return items
    }

    /**
     * 设置数据
     */
    override fun setData(list: List<M>) {
        val multiList = list.multiList()
        items.run {
            clear()
            addAll(multiList)
        }
        notifyDataSetChanged()
    }

    /**
     * 添加数据
     */
    override fun addData(list: List<M>) {
        val multiList = list.multiList()
        val preSize = items.size
        items.run {
            addAll(multiList)
        }
        notifyItemRangeInserted(preSize, multiList.size)
    }

    /**
     * 只刷新局部数据。
     */
    override fun changeData(list: List<M>) {
        val multiList = list.multiList()
        for (m in multiList) {
            if (m in items) {
                val index = items.indexOf(m)
                notifyItemChanged(index)
            }
        }
    }

    /**
     * 只移除局部数据。
     */
    override fun removeData(list: List<M>) {
        val multiList = list.multiList()
        for (m in multiList) {
            if (m in items) {
                val index = items.indexOf(m)
                items.remove(m)
                notifyItemRemoved(index)
            }
        }
    }

    /**
     * 清空数据
     */
    override fun clearData() {
        items.clear()
    }
}
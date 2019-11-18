package top.wzmyyj.adapter.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
abstract class BaseAdapter<T : IModelType> : RecyclerView.Adapter<BaseViewHolder>() {

    private val ivdManager: ViewTypeDelegateManager<T> = ViewTypeDelegateManager()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        addDelegate(ivdManager)
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        ivdManager.clear()
        super.onDetachedFromRecyclerView(recyclerView)
    }


    abstract fun onCreateVHForAll(binding: ViewDataBinding)

    abstract fun onBindVHForAll(binding: ViewDataBinding, m: T)

    /**
     * 初始化各种viewType处理委托。添加到Manager中。
     */
    protected open fun addDelegate(manager: ViewTypeDelegateManager<T>) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val holder = createVH(parent, viewType)
        onCreateVHForAll(holder.binding)
        ivdManager.onCreateVH(holder.binding, viewType)
        return holder
    }

    protected open fun createVH(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), viewType, parent, false
        )
        return BaseViewHolder(binding)
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = list()[position]
        onBindVHForAll(holder.binding, item)
        ivdManager.onBindVH(holder.binding, item)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return list().size
    }

    override fun getItemViewType(position: Int): Int {
        return list()[position].getViewType()
    }

    protected abstract fun list(): List<T>

    /**
     * List数据结构需要改变时重写。即传入 List 经过变化后变成 items 需要的list。默认不改变结构。
     */
    protected abstract fun List<T>.multiList(): List<T>

}
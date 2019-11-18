package top.wzmyyj.adapter.diff

import top.wzmyyj.adapter.base.IModelType

/**
 * Created on 2019/11/18.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
interface IModelDiff<D : IModelDiff<D>> : IModelType {

    fun areContentsTheSame(other: D): Boolean {
        return this == other
    }

    fun areItemsTheSame(other: D): Boolean {
        return this == other
    }
}

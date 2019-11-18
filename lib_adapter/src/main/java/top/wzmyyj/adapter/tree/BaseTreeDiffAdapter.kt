package top.wzmyyj.adapter.tree

import top.wzmyyj.adapter.diff.BaseDiffAdapter
import top.wzmyyj.adapter.diff.IModelDiff

/**
 * Created on 2019/11/18.
 *
 * @author feling
 * @version 1.1.0
 * @since 1.1.0
 */
abstract class BaseTreeDiffAdapter<T> : BaseDiffAdapter<T>()
        where T : IModelTree<T>, T : IModelDiff<T> {
    override fun List<T>.multiList(): List<T> {
        return ArrayList<T>().also { multiList ->
            this.forEach { tree ->
                multiList.addAll(IModelTree.ergodic(tree))
            }
        }
    }
}
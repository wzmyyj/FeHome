package top.wzmyyj.adapter.tree

import top.wzmyyj.adapter.list.BaseListAdapter

/**
 * Created on 2019/08/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
abstract class BaseTreeAdapter<T : IModelTree<T>> : BaseListAdapter<T>() {
    override fun List<T>.multiList(): List<T> {
        return ArrayList<T>().also { multiList ->
            this.forEach { tree ->
                multiList.addAll(IModelTree.ergodic(tree))
            }
        }
    }
}
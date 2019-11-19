package top.wzmyyj.adapter.tree

import top.wzmyyj.adapter.base.BaseAdapter

/**
 * Created on 2019/11/18.
 *
 * @author feling
 * @version 1.1.0
 * @since 1.1.0
 */
fun <T : IModelTree<T>> BaseAdapter<T>.fixToTree() {
    this.setIFix(object : BaseAdapter.IFix<T> {
        override fun fix(list: List<T>): List<T> {
            return ArrayList<T>().also { multiList ->
                list.forEach { tree ->
                    multiList.addAll(IModelTree.ergodic(tree))
                }
            }
        }
    })
}


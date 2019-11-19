package top.wzmyyj.active.model

import android.os.Bundle
import top.wzmyyj.active.R

/**
 * Created on 2019/11/15.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class ActivePathModel(
    /**
     * path
     */
    var path: String = "",
    /**
     * target
     */
    var target: String = "",
    /**
     *
     */
    var params: Bundle? = null,
    /**
     * title
     */
    var title: String = "",
    /**
     * desc
     */
    var desc: String = ""

) : IActiveModelType {

    override fun getViewType() = R.layout.active_item_path

    interface OnItemEventListener {
        fun onPathClick(model: ActivePathModel)
    }
}
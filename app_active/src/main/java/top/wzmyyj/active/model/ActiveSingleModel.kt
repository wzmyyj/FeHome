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
class ActiveSingleModel(
    /**
     * action
     */
    var action: Int = 0,

    /**
     * title
     */
    var title: String = "",
    /**
     * desc
     */
    var desc: String = ""

) : IActiveModelType {

    override fun getViewType() = R.layout.active_item_single

    interface OnItemEventListener {
        fun onSingleClick(model: ActiveSingleModel)
    }
}
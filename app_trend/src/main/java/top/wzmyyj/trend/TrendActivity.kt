package top.wzmyyj.trend

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.base.CBaseActivity
import top.wzmyyj.common.base.replaceFragment
import top.wzmyyj.common_service.ActivityPath
import top.wzmyyj.trend.model.User
import top.wzmyyj.trend.ui.TrendFragment


/**
 * Created on 2019/11/14.
 *
 * @author feling
 * @version 1.0.1
 * @since 1.0.0
 */
@Route(path = ActivityPath.TREND, name = "动态模块")
class TrendActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_activity)
        replaceFragment(R.id.fragment_container, TrendFragment.newInstance())
    }

    fun test() {


        val oldList = ArrayList<User>()
        val newList = ArrayList<User>()


        val diffCallback = object : DiffUtil.Callback() {

            override fun getOldListSize(): Int {
                return oldList.size
            }

            override fun getNewListSize(): Int {
                return newList.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].id == newList[newItemPosition].id
            }


            override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
                return null
            }

        }

        val diffResult = DiffUtil.calculateDiff(diffCallback)

//        mAdapter.setData(newList)
//        diffResult.dispatchUpdatesTo(mAdapter)

    }
}

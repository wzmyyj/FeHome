package top.wzmyyj.active

import android.content.res.Resources
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.active.ui.ActiveFragment
import top.wzmyyj.active.ui.WorkFragment
import top.wzmyyj.active.utils.AdaptScreenUtil
import top.wzmyyj.common_service.ActivityPath
import top.wzmyyj.common_service.RouterManager

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ActivityPath.ACTIVE, name = "活动模块")
class ActiveActivity : TestActivity() {

    override fun getFragment(): Fragment? {
        val target = RouterManager.getTargetString(intent) ?: return ActiveFragment.newInstance()
        when (target) {
            "work" -> return WorkFragment.newInstance()
        }
        return ActiveFragment.newInstance()
    }

    override fun getResources(): Resources {
        return AdaptScreenUtil.adaptWidth(super.getResources(), 375)
    }
}

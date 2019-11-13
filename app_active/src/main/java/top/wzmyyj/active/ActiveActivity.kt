package top.wzmyyj.active

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.active.ui.ActiveFragment
import top.wzmyyj.common_service.ActivityPath

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
        return ActiveFragment.newInstance()
    }
}

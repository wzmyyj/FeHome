package top.wzmyyj.home

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.common_service.ActivityPath
import top.wzmyyj.home.ui.HomeFragment

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ActivityPath.HOME, name = "首页模块")
class HomeActivity : TestActivity() {

    override fun getFragment(): Fragment? {
        return HomeFragment.newInstance()
    }
}

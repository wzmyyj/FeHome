package top.wzmyyj.mine

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.common_service.ActivityPath
import top.wzmyyj.mine.ui.MineFragment

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ActivityPath.MINE, name = "我的模块")
class MineActivity : TestActivity() {

    override fun getFragment(): Fragment? {
        return MineFragment.newInstance()
    }
}

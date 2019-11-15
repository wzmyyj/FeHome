package top.wzmyyj.trend

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.base.CBaseActivity
import top.wzmyyj.common.base.replaceFragment
import top.wzmyyj.common_service.ActivityPath
import top.wzmyyj.trend.ui.TrendFragment

/**
 * Created on 2019/11/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ActivityPath.TREND, name = "动态模块")
class TrendActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_activity)
        replaceFragment(R.id.fragment_container, TrendFragment.newInstance())
    }
}

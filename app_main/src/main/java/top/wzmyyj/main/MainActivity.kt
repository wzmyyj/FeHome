package top.wzmyyj.main

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.base.CBaseActivity
import top.wzmyyj.common.base.replaceFragment
import top.wzmyyj.common_service.ActivityPath
import top.wzmyyj.main.ui.MainFragment

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ActivityPath.MAIN, name = "主页模块")
class MainActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        replaceFragment(R.id.fragment_container, MainFragment.newInstance())
    }
}

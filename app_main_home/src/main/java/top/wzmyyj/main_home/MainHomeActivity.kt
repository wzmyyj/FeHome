package top.wzmyyj.main_home

import androidx.fragment.app.Fragment
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.main_home.ui.MainHomeFragment

class MainHomeActivity : TestActivity() {

    override fun getFragment(): Fragment? {
        return MainHomeFragment.newInstance()
    }
}

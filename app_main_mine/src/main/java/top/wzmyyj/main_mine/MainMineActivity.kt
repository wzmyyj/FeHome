package top.wzmyyj.main_mine

import androidx.fragment.app.Fragment
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.main_mine.ui.MainMineFragment

class MainMineActivity : TestActivity() {

    override fun getFragment(): Fragment? {
        return MainMineFragment.newInstance()
    }
}

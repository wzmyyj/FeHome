package top.wzmyyj.main_active

import androidx.fragment.app.Fragment
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.main_active.ui.MainActiveFragment

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

class MainActiveActivity : TestActivity() {

    override fun getFragment(): Fragment? {
        return MainActiveFragment.newInstance()
    }
}

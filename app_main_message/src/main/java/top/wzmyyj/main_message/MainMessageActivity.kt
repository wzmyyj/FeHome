package top.wzmyyj.main_message

import androidx.fragment.app.Fragment
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.main_message.ui.MainMessageFragment

class MainMessageActivity : TestActivity() {

    override fun getFragment(): Fragment? {
        return MainMessageFragment.newInstance()
    }

}

package top.wzmyyj.common.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import top.wzmyyj.common.R
import top.wzmyyj.common.base.CBaseActivity
import top.wzmyyj.common.base.replaceFragment

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class TestActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_activity)

        getFragment()?.let {
            replaceFragment(R.id.fragment_container, it, false)
        }
    }


    protected open fun getFragment(): Fragment? {
        return null
    }

}
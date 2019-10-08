package top.wzmyyj.main

import android.os.Bundle
import top.wzmyyj.common.base.CBaseActivity
import top.wzmyyj.common.base.replaceFragment
import top.wzmyyj.main.fragment.MainFragment

class MainActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        replaceFragment(R.id.fragment_container, MainFragment.newInstance())
    }
}

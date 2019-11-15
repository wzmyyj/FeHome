package top.wzmyyj.fehome.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class FeHomeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
        ARouter.openDebug()
    }
}
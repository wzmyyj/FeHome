package top.wzmyyj.common_service

import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created on 2019/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
object RouterManager {

    private const val TARGET = "target"
    private const val PARAMS = "params"
    private const val FROM_PAGE = "from_page"


    fun goPage(path: String, target: String, params: Bundle, fromPage: String) {
        postcard(path, target, params, fromPage).navigation()
    }

    private fun postcard(
        @ActivityPath path: String, target:
        String, params: Bundle, fromPage: String
    ): Postcard {
        return ARouter.getInstance().build(path)
            .withString(FROM_PAGE, fromPage)
            .withString(TARGET, target)
            .withBundle(PARAMS, params)
    }

    fun <T> getService(service: Class<out T>): T? {
        return ARouter.getInstance().navigation(service)
    }
}
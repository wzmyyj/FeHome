package top.wzmyyj.common_service

import android.content.Intent
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


    /**
     * 获取FromPage字段。
     */
    fun getFromPageString(intent: Intent?): String? {
        if (intent == null) {
            return null
        }
        return intent.getStringExtra(FROM_PAGE)
    }

    /**
     * 获取Target字段。
     */
    fun getTargetString(intent: Intent?): String? {
        if (intent == null) {
            return null
        }
        return intent.getStringExtra(TARGET)
    }

    /**
     * 获取Params字段。
     */
    fun getParamsString(intent: Intent?): Bundle? {
        if (intent == null) {
            return null
        }
        return intent.getBundleExtra(PARAMS)
    }

    fun goMain(fromPage: String) {
        postcard(ActivityPath.MAIN, "", null, fromPage)
            .navigation()
    }
//
//    fun goActive(fromPage: String, params: Bundle? = null) {
//        postcard(ActivityPath.TREND, "", params, fromPage)
//            .navigation()
//    }
//
//
//    fun goTrend(fromPage: String) {
//        postcard(ActivityPath.TREND, "", null, fromPage)
//            .navigation()
//    }


    fun goPage(path: String, target: String, params: Bundle?, fromPage: String) {
        if (!ActivityPath.isIn(path)) return
        postcard(path, target, params, fromPage)
            .navigation()
    }

    private fun postcard(
        @ActivityPath path: String, target:
        String, params: Bundle?, fromPage: String
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
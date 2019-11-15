package top.wzmyyj.common_service

import androidx.annotation.StringDef

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

@StringDef(
    ActivityPath.MAIN,
    ActivityPath.HOME,
    ActivityPath.ACTIVE,
    ActivityPath.MESSAGE,
    ActivityPath.MINE
)
annotation class ActivityPath {
    companion object {

        const val MAIN = "/main/activity"

        const val HOME = "/home/activity"

        const val ACTIVE = "/active/activity"

        const val MESSAGE = "/message/activity"

        const val MINE = "/mine/activity"

        const val TREND = "/trend/activity"

        fun isIn(path: String): Boolean {
            return path == MAIN
                    || path == HOME
                    || path == ACTIVE
                    || path == MESSAGE
                    || path == TREND

        }
    }
}


@StringDef(
    ServicePath.HOME,
    ServicePath.ACTIVE,
    ServicePath.MESSAGE,
    ServicePath.MINE
)
annotation class ServicePath {
    companion object {

        const val HOME = "/home/service"

        const val ACTIVE = "/active/service"

        const val MESSAGE = "/message/service"

        const val MINE = "/mine/service"

    }
}

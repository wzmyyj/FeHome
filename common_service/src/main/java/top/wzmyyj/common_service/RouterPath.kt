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

        const val MAIN = "/main/module"

        const val HOME = "/home/module"

        const val ACTIVE = "/active/module"

        const val MESSAGE = "/message/module"

        const val MINE = "/mine/module"

        fun isIn(path: String): Boolean {
            return MAIN == path
                    || HOME == path
                    || ACTIVE == path
                    || MESSAGE == path

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

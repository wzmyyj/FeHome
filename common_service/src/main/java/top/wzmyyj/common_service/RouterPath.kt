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
    ModulePath.MAIN_HOME,
    ModulePath.MAIN_ACTIVE,
    ModulePath.MAIN_MESSAGE,
    ModulePath.MAIN_MINE
)
annotation class ModulePath {
    companion object {

        const val MAIN_HOME = "/main_home/module"

        const val MAIN_ACTIVE = "/main_active/module"

        const val MAIN_MESSAGE = "/main_message/module"

        const val MAIN_MINE = "/main_mine/module"


        fun isIn(name: String): Boolean {
            return MAIN_HOME == name
                    || MAIN_ACTIVE == name
                    || MAIN_MESSAGE == name
                    || MAIN_MINE == name
        }

    }
}


@StringDef(
    ServicePath.MAIN_HOME,
    ServicePath.MAIN_ACTIVE,
    ServicePath.MAIN_MESSAGE,
    ServicePath.MAIN_MINE
)
annotation class ServicePath {
    companion object {

        const val MAIN_HOME = "/main_home/service"

        const val MAIN_ACTIVE = "/main_active/service"

        const val MAIN_MESSAGE = "/main_message/service"

        const val MAIN_MINE = "/main_mine/service"

        fun isIn(name: String): Boolean {
            return MAIN_HOME == name
                    || MAIN_ACTIVE == name
                    || MAIN_MESSAGE == name
                    || MAIN_MINE == name
        }

    }
}

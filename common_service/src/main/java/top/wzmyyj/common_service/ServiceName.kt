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
    ServiceName.SERVICE_MAIN_HOME,
    ServiceName.SERVICE_MAIN_ACTIVE
)
annotation class ServiceName {
    companion object {

        const val SERVICE_MAIN_HOME = "/service/main_home"

        const val SERVICE_MAIN_ACTIVE = "/service/main_active"

        fun isIn(name: String): Boolean {
            return SERVICE_MAIN_HOME == name
                    || SERVICE_MAIN_ACTIVE == name
        }

    }
}

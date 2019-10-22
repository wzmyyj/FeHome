package top.wzmyyj.common_service.main_home

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
interface IMainHomeService : IProvider {

    fun getFragment(): Fragment
}
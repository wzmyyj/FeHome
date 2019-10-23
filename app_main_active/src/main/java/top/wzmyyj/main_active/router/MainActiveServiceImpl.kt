package top.wzmyyj.main_active.router

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.main_active.IMainActiveService
import top.wzmyyj.main_active.ui.MainActiveFragment

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.MAIN_ACTIVE)
class MainActiveServiceImpl : IMainActiveService {
    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return MainActiveFragment.newInstance()
    }

}
package top.wzmyyj.main_home.router

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.main_home.IMainHomeService
import top.wzmyyj.main_home.ui.MainHomeFragment

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.MAIN_HOME)
class MainHomeServiceImpl : IMainHomeService {
    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return MainHomeFragment.newInstance()
    }

}
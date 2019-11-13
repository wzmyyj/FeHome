package top.wzmyyj.active

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.active.IActiveService
import top.wzmyyj.active.ui.ActiveFragment

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.ACTIVE)
class ActiveServiceImpl : IActiveService {
    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return ActiveFragment.newInstance()
    }

}
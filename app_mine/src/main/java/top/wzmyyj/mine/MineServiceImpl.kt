package top.wzmyyj.mine

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.mine.IMineService
import top.wzmyyj.mine.ui.MineFragment

/**
 * Created on 2019/11/13.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.MINE)
class MineServiceImpl :IMineService {
    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return MineFragment.newInstance()
    }
}
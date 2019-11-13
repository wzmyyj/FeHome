package top.wzmyyj.message

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.message.IMessageService
import top.wzmyyj.message.ui.MessageFragment

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.MESSAGE)
class MessageServiceImpl : IMessageService {
    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return MessageFragment.newInstance()
    }

}
package top.wzmyyj.message

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.test.TestActivity
import top.wzmyyj.common_service.ActivityPath
import top.wzmyyj.message.ui.MessageFragment

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ActivityPath.MESSAGE, name = "消息模块")
class MessageActivity : TestActivity() {

    override fun getFragment(): Fragment? {
        return MessageFragment.newInstance()
    }

}

package top.wzmyyj.fehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.wzmyyj.common_service.RouterManager

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        RouterManager.goMain("Launcher")
        finish()
    }
}

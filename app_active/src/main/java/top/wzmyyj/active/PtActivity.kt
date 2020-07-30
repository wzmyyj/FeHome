package top.wzmyyj.active

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.wzmyyj.active.utils.AdaptScreenUtil

class PtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pt)
    }

    override fun getResources(): Resources {
        return AdaptScreenUtil.adaptWidth(super.getResources(), 275)
    }
}
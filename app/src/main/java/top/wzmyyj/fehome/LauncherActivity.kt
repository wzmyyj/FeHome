package top.wzmyyj.fehome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.wzmyyj.main.MainActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        val i = Intent()
        i.setClass(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }
}

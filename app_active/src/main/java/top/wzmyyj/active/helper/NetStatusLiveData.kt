package top.wzmyyj.active.helper

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.util.Log
import androidx.lifecycle.LiveData


/**
 * Created on 2020/04/03.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
object NetStatusLiveData : LiveData<Int>() {

    private const val TAG = "NetStatusLiveData"
    private lateinit var app: Application
    private var debug: Boolean = false

    private val receiver by lazy {
        NetBroadcastReceiver()
    }

    fun init(app: Application, debug: Boolean = false) {
        this.app = app
        this.debug = debug
    }

    override fun onActive() {
        super.onActive()
        val filter = IntentFilter()
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        app.registerReceiver(receiver, filter)
    }

    override fun onInactive() {
        super.onInactive()
        app.unregisterReceiver(receiver)
    }

    private fun setNetWorkState(netWorkState: Int) {
        if (debug) {
            Log.d(TAG, "NetWorkState: $netWorkState")
        }
        value = netWorkState
    }

    class NetBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) { // 如果相等的话就说明网络状态发生了变化
            if (intent.action == ConnectivityManager.CONNECTIVITY_ACTION) {
                val netWorkState: Int = getNetWorkState(context ?: return)
                // 接口回调传过去状态的类型
                setNetWorkState(netWorkState)
            }
        }
    }

    /**
     * 没有连接网络
     */
    const val NETWORK_NONE = -1
    /**
     * 移动网络
     */
    const val NETWORK_MOBILE = 0
    /**
     * 无线网络
     */
    const val NETWORK_WIFI = 1

    /**
     * 获取网络状态。
     */
    private fun getNetWorkState(context: Context): Int { // 得到连接管理器对象
        val connectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager
            .activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
                return NETWORK_WIFI
            } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE) {
                return NETWORK_MOBILE
            }
        } else {
            return NETWORK_NONE
        }
        return NETWORK_NONE
    }

}
package top.wzmyyj.active.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.work.*
import top.wzmyyj.active.databinding.ActiveWorkFragmentBinding
import top.wzmyyj.common.base.CBaseFragment
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created on 2020/04/03.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class WorkFragment : CBaseFragment() {

    companion object {
        fun newInstance() = WorkFragment()
    }

    private val binding by lazy {
        ActiveWorkFragmentBinding.inflate(layoutInflater)
    }

    private val initOnce by lazy {
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initOnce
    }

    private var c = 0
    private fun initView() {
        binding.bt1.setOnClickListener {
            doWork()
            binding.tv2.text = "任务数量".plus(++c)
        }
    }


    private fun doWork() {
        val dateFormat = SimpleDateFormat("hh:mm:ss", Locale.getDefault())

        val data = Data.Builder()
            .putString("time", dateFormat.format(Date()))
            .build()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val request = OneTimeWorkRequest.Builder(DemoWorker::class.java)
            .setInputData(data)
            .setConstraints(constraints)
            .build()

        WorkManager
            .getInstance(context ?: return)
            .enqueue(request)

        WorkManager
            .getInstance(context ?: return)
            .getWorkInfoByIdLiveData(request.id)
            .observe(this, androidx.lifecycle.Observer {
                if (it != null && it.state.isFinished) {
                    Log.d("FE_WORK", it.outputData.getString("name").orEmpty())
                }
            })

    }


    class DemoWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
        override fun doWork(): Result {
            Log.d("FE_WORK", inputData.getString("time").orEmpty())
            Log.d("FE_WORK", "Thread id:" + Thread.currentThread().id)
            return Result.success()
        }
    }


}
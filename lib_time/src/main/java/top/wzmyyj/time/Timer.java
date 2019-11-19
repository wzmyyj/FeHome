package top.wzmyyj.time;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/**
 * Created on 2019/10/23.
 * <p>
 * 真正的时间流逝逻辑类。
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class Timer {

    interface OnTickListener {
        void onTick(long tickTime);
    }

    @NonNull
    private final OnTickListener onTickListener;

    public Timer(@NonNull OnTickListener onTickListener) {
        this.timerInterval = TimerInterval.IntervalLV1;
        this.onTickListener = onTickListener;
    }


    /**
     * The interval in millis that the user receives callbacks
     */
    @TimerInterval
    private long timerInterval;

    public void setTimerInterval(@TimerInterval long timerInterval) {
        if (this.timerInterval == timerInterval) return;
        this.timerInterval = timerInterval;
    }

    public long getTimerInterval() {
        return timerInterval;
    }


    /**
     * boolean representing if the timer was cancelled
     */
    private boolean mCancelled = false;


    /**
     * Cancel the timer.
     */
    public synchronized final void cancel() {
        mCancelled = true;
        mHandler.removeMessages(MSG);
    }

    /**
     * Start the timer.
     */
    public synchronized final void start() {
        mCancelled = false;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
    }

    private static final int MSG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(@NonNull Message msg) {

            synchronized (Timer.this) {
                if (mCancelled) {
                    return;
                }
                final long millis = System.currentTimeMillis();
                onTickListener.onTick(millis);
                sendMessageDelayed(obtainMessage(MSG), timerInterval);
            }
        }
    };
}

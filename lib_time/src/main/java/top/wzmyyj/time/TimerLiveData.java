package top.wzmyyj.time;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.LongDef;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

/**
 * Created on 2019/10/21.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class TimerLiveData extends LiveData<Long> {

    @MainThread
    private TimerLiveData() {
        timer = new Timer(this::setValue);
    }

    private static class Holder {
        private static final TimerLiveData instance = new TimerLiveData();
    }

    @NonNull
    public static TimerLiveData getInstance() {
        return Holder.instance;
    }

    @NonNull
    private final Timer timer;


    public void minTimerInterval(@TimerInterval long timerInterval) {
        if (timer.getTimerInterval() > timerInterval) {
            timer.setTimerInterval(timerInterval);
        }
    }


    @Override
    protected void onActive() {
        super.onActive();
        timer.start();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        timer.cancel();
    }


    @LongDef({
            TimerInterval.IntervalLV0,
            TimerInterval.IntervalLV1,
            TimerInterval.IntervalLV2,
            TimerInterval.IntervalLV3
    })
    public @interface TimerInterval {
        long IntervalLV0 = 10L;
        long IntervalLV1 = 100L;
        long IntervalLV2 = 1000L;
        long IntervalLV3 = 60000L;
    }

    @MainThread
    public static class Timer {

        interface OnTickListener {
            void onTick(long tickTime);
        }

        public Timer(@NonNull OnTickListener onTickListener) {
            this.timerInterval = TimerInterval.IntervalLV1;
            this.onTickListener = onTickListener;
        }


        /**
         * The interval in millis that the user receives callbacks
         */
        @TimerInterval
        private long timerInterval;

        public void setTimerInterval(long timerInterval) {
            this.timerInterval = timerInterval;
        }

        public long getTimerInterval() {
            return timerInterval;
        }

        @NonNull
        private final OnTickListener onTickListener;


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
        private Handler mHandler = new Handler() {

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


}

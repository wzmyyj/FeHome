package top.wzmyyj.time;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/**
 * Created on 2019/10/21.
 *
 * 倒计时观察者。
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class CountDownTimer implements Observer<Long>, TimerInterval.Get {

    public CountDownTimer() {
        this.timerInterval = TimerInterval.IntervalLV2;
    }

    public CountDownTimer(@TimerInterval long timerInterval) {
        this.timerInterval = timerInterval;
    }

    @Override
    @TimerInterval
    public long getTimerInterval() {
        return timerInterval;
    }

    @TimerInterval
    private final long timerInterval;

    private long endTime;

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        setEndTime(endTime, false);
    }

    public void setEndTime(long endTime, boolean doFirst) {
        if (this.endTime == endTime) return;
        this.isEnd = endTime <= System.currentTimeMillis();
        if (isEnd && doFirst && onCountdownEndListener != null) {
            onCountdownEndListener.onEnd();
        }
        this.endTime = endTime;
    }

    private OnCountdownEndListener onCountdownEndListener;
    private OnCountdownTickListener onCountdownTickListener;

    public void setOnCountdownEndListener(OnCountdownEndListener onCountdownEndListener) {
        this.onCountdownEndListener = onCountdownEndListener;
    }

    public void setOnCountdownTickListener(OnCountdownTickListener onCountdownTickListener) {
        this.onCountdownTickListener = onCountdownTickListener;
    }


    public interface OnCountdownEndListener {
        void onEnd();
    }

    public interface OnCountdownTickListener {
        void onTick(long remain);
    }

    private boolean isEnd = false;


    private long nowTime = 0;

    @Override
    public final void onChanged(Long aLong) {
        if (isEnd) return;
        if (Math.abs(aLong - nowTime) < timerInterval) return;
        nowTime = aLong;
        if (nowTime >= endTime) {
            if (onCountdownEndListener != null) {
                onCountdownEndListener.onEnd();
                isEnd = true;
            }
        } else {
            if (onCountdownTickListener != null) {
                onCountdownTickListener.onTick(endTime - nowTime);
            }
        }

    }

    /**
     * Cancel the timer.
     */
    public synchronized final void detach() {
        TimerLiveData.getInstance().removeObserver(this);
    }

    /**
     * Start the timer.
     */
    public synchronized final void attach(@NonNull LifecycleOwner owner) {
        TimerLiveData.getInstance().observe(owner, this);
    }


    /**
     * Start the timer.
     */
    public synchronized final void attach(@NonNull View v) {
        LifecycleOwner owner = Util.getOwner(v);
        if (owner == null) return;
        attach(owner);
    }

    /**
     * Start the timer.
     */
    public synchronized final void attachForever() {
        TimerLiveData.getInstance().observeForever(this);
    }
}

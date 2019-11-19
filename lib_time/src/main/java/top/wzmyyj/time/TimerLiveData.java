package top.wzmyyj.time;

import android.util.LongSparseArray;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/**
 * Created on 2019/10/21.
 *
 * 时间流逝服务，单例。
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class TimerLiveData extends LiveData<Long> {

    private TimerLiveData() {
        timer = new Timer(this::setValue);
        array = new LongSparseArray<>();
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

    @NonNull
    private final LongSparseArray<Integer> array;

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

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super Long> observer) {
        super.observe(owner, observer);
        if (observer instanceof TimerInterval.Get) {
            modTimerInterval((TimerInterval.Get) observer, 1);
        }
    }

    @Override
    public void observeForever(@NonNull Observer<? super Long> observer) {
        super.observeForever(observer);
        if (observer instanceof TimerInterval.Get) {
            modTimerInterval((TimerInterval.Get) observer, 1);
        }

    }

    @Override
    public void removeObserver(@NonNull Observer<? super Long> observer) {
        super.removeObserver(observer);
        if (observer instanceof TimerInterval.Get) {
            modTimerInterval((TimerInterval.Get) observer, -1);
        }
    }


    private void modTimerInterval(TimerInterval.Get o, int plus) {
        @TimerInterval
        long interval = o.getTimerInterval();
        int count = array.get(interval, 0);
        array.put(interval, count + plus);
        minTimerInterval();
    }

    private void minTimerInterval() {
        if (array.get(TimerInterval.IntervalLV0,0) > 0) {
            timer.setTimerInterval(TimerInterval.IntervalLV0);
        } else if (array.get(TimerInterval.IntervalLV1,0) > 0) {
            timer.setTimerInterval(TimerInterval.IntervalLV1);
        } else {
            timer.setTimerInterval(TimerInterval.IntervalLV2);
        }
    }


}

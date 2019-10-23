package top.wzmyyj.time;

import androidx.annotation.LongDef;

/**
 * Created on 2019/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

@LongDef({
        TimerInterval.IntervalLV0,
        TimerInterval.IntervalLV1,
        TimerInterval.IntervalLV2
})
public @interface TimerInterval {
    long IntervalLV0 = 10L;
    long IntervalLV1 = 100L;
    long IntervalLV2 = 1000L;

    interface Get {
        @TimerInterval
        long getTimerInterval();
    }
}

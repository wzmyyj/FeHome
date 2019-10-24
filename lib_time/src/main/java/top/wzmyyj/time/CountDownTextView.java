package top.wzmyyj.time;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created on 2019/10/21.
 *
 * 倒计时控件示例。
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class CountDownTextView extends AppCompatTextView {

    private String formatString = "HH:mm:ss";

    public CountDownTextView(Context context) {
        this(context, null);
    }

    public CountDownTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private CountDownTimer countDownTimer = new CountDownTimer();


    public void init() {
        countDownTimer.setOnCountdownTickListener(remain -> {
            final long oneDay = (long) 1000 * 60 * 60 * 24;
            int day = (int) (remain / oneDay);
            int S = (int) (remain / 100 % 10);
            int s = (int) (remain / 1000 % 60);
            int m = (int) (remain / 1000 / 60 % 60);
            int h = (int) (remain / 1000 / 60 / 60 % 24);
            int h1 = day * 24 + h;
            String mm = m < 10 ? "0" + m : "" + m;
            String ss = s < 10 ? "0" + s : "" + s;
            String hh = h1 < 10 ? "0" + h1 : "" + h1;
            String str = formatString
                    .replace("HH", hh)
                    .replace("mm", mm)
                    .replace("ss", ss)
                    .replace("S", S + "");
            CountDownTextView.this.setText(str);

        });

        countDownTimer.setOnCountdownEndListener(() -> {
            String s = "00:00:00";
            CountDownTextView.this.setText(s);
        });
    }


    public void setEndTime(long endTime) {
        countDownTimer.setEndTime(endTime, true);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        countDownTimer.attach(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        countDownTimer.detach();
    }
}

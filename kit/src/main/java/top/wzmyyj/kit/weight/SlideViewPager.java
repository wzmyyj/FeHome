package top.wzmyyj.kit.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by feling on 2018/12/28.
 * <p>
 * 可以控制是否可滑动的ViewPager。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class SlideViewPager extends ViewPager {
    public SlideViewPager(@NonNull Context context) {
        super(context);
    }

    public SlideViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private boolean isSlide = true;

    /**
     * @return isSlide.
     */
    public boolean isSlide() {
        return isSlide;
    }

    /**
     * @param isSlide .
     */
    public void setSlide(boolean isSlide) {
        this.isSlide = isSlide;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isSlide && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isSlide && super.onInterceptTouchEvent(ev);
    }
}

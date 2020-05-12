package top.wzmyyj.kit.weight;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import top.wzmyyj.kit.R;

/**
 * Created on 2020/02/26.
 *
 * @author feling
 * @version im
 * @since im
 */
public class SideBar extends View {
    // 触摸事件
    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    // 26个字母
    public static String[] B = {"★", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"};
    public static String[] emptyB = new String[0];

    private int choose = -1;// 选中
    private Paint paint = new Paint();
    private String[] b = B;

    @ColorInt
    private int textColor;
    @ColorInt
    private int textColorHighlight;
    private Typeface typeface;
    private int textSize;

    private TextView mTextDialog;

    public void setTextView(TextView mTextDialog) {
        this.mTextDialog = mTextDialog;
    }


    public SideBar(Context context) {
        this(context, null);
    }

    public SideBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SideBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SideBar, defStyle, 0);
        textColor = a.getColor(R.styleable.SideBar_android_textColor, 0xFF666666);
        textColorHighlight = a.getColor(R.styleable.SideBar_android_textColorHighlight, 0xFF333333);
        textSize = a.getDimensionPixelSize(R.styleable.SideBar_android_textSize, 35);
        int textStyle = a.getInteger(R.styleable.SideBar_android_textStyle, 0);
        typeface = Typeface.create(Typeface.DEFAULT_BOLD, textStyle);
        a.recycle();
    }

    /**
     * 重写这个方法
     */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (b == null || b.length == 0) return;
        // 获取焦点改变背景颜色.
        int height = getHeight() - getPaddingTop() - getPaddingBottom();// 获取对应高度
        int width = getWidth() - getPaddingLeft() - getPaddingRight(); // 获取对应宽度
        int singleHeight = height / b.length;// 获取每一个字母的高度

        for (int i = 0; i < b.length; i++) {
            paint.setColor(textColor);
            paint.setTypeface(typeface);
            paint.setAntiAlias(true);
            paint.setTextSize(textSize);
            // 选中的状态
            if (i == choose) {
                paint.setColor(textColorHighlight);
                paint.setFakeBoldText(true);
            }
            // x坐标等于中间-字符串宽度的一半.
            float xPos = width / 2f - paint.measureText(b[i]) / 2 + getPaddingLeft();
            float yPos = singleHeight / 2f + singleHeight * i + getPaddingTop() + textSize / 2f;
            canvas.drawText(b[i], xPos, yPos, paint);
            paint.reset();// 重置画笔
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (b == null || b.length == 0) return super.dispatchTouchEvent(event);
        getParent().requestDisallowInterceptTouchEvent(false);
        final int action = event.getAction();
        final int height = getHeight() - getPaddingTop() - getPaddingBottom();// 获取对应高度
        final float y = event.getY() - getPaddingTop();// 点击y坐标
        final int oldChoose = choose;
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
        final int singleHeight = height / b.length;// 获取每一个字母的高度
        final int c = (int) (y / singleHeight);// 点击y坐标所占总高度的比例*b数组的长度就等于点击b中的个数.

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                setBackgroundColor(0x55EEEEEE);
                setAlpha(0.7f);
                if (oldChoose != c) {
                    if (c >= 0 && c < b.length) {
                        choose = c;
                        if (listener != null) {
                            listener.onTouchingLetterChanged(b[c]);
                        }
                        if (mTextDialog != null) {
                            mTextDialog.setText(b[c]);
                            mTextDialog.setTranslationY((c + 0.5f) * singleHeight - mTextDialog.getHeight() / 2f);
                            mTextDialog.setVisibility(View.VISIBLE);
                        }
                        invalidate();
                    }
                }

                break;
            default:
                setBackgroundColor(0x00000000);
                setAlpha(1f);
                choose = -1;
                invalidate();
                if (mTextDialog != null) {
                    mTextDialog.setVisibility(View.INVISIBLE);
                }
                break;

        }
        return true;
    }

    /**
     * 设置监听。
     *
     * @param onTouchingLetterChangedListener .
     */
    public void setOnTouchingLetterChangedListener(
            OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    /**
     * 触摸监听。
     */
    public interface OnTouchingLetterChangedListener {
        void onTouchingLetterChanged(@NonNull String s);
    }

    /**
     * 设置字母表。
     *
     * @param list 。
     */
    public void setLetterList(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            b = emptyB;
            return;
        }
        int size = list.size();
        String[] a = new String[size];
        for (int i = 0; i < size; i++) {
            a[i] = list.get(i);
        }
        b = a;
        invalidate();
    }

}

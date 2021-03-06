package top.wzmyyj.kit.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import top.wzmyyj.kit.R;

/**
 * Created on 2018/12/07.
 *
 * 有圆角的ImageView。
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

public class RoundAngleImageView extends AppCompatImageView {
    float width, height;

    private int radiusLeftTop;
    private int radiusLeftBottom;
    private int radiusRightTop;
    private int radiusRightBottom;
    private int mBorderColor;
    private int mBorderWidth;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 获取属性。
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundAngleImageView, defStyleAttr, 0);
        int radius = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_riv_radius, 0);
        radiusLeftTop = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_riv_leftTop_radius, radius);
        radiusLeftBottom = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_riv_leftBottom_radius, radius);
        radiusRightTop = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_riv_rightTop_radius, radius);
        radiusRightBottom = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_riv_rightBottom_radius, radius);

        mBorderWidth = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_riv_border_width, 0);
        mBorderColor = a.getColor(R.styleable.RoundAngleImageView_riv_border_color, 0);
        a.recycle();

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    /**
     * @return mBorderColor.
     */
    public int getBorderColor() {
        return mBorderColor;
    }

    /**
     * @param borderColor .
     */
    public void setBorderColor(int borderColor) {
        if (borderColor == mBorderColor) {
            return;
        }
        mBorderColor = borderColor;
        invalidate();
    }

    /**
     * @return mBorderWidth.
     */
    public int getBorderWidth() {
        return mBorderWidth;
    }

    /**
     * @param borderWidth .
     */
    public void setBorderWidth(int borderWidth) {
        if (borderWidth == mBorderWidth) {
            return;
        }

        mBorderWidth = borderWidth;
        invalidate();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        if (width >= (radiusLeftTop + radiusRightTop)
                && width >= (radiusLeftBottom + radiusRightBottom)
                && height >= (radiusLeftTop + radiusLeftBottom)
                && height >= (radiusRightTop + radiusRightBottom)) {
            //四个圆角
            Paint paint = new Paint();
            Path path = new Path();

            path.moveTo(radiusLeftTop, 0);
            path.lineTo(width - radiusRightTop, 0);
            path.quadTo(width, 0, width, radiusRightTop);
            path.lineTo(width, height - radiusRightBottom);
            path.quadTo(width, height, width - radiusRightBottom, height);
            path.lineTo(radiusLeftBottom, height);
            path.quadTo(0, height, 0, height - radiusLeftBottom);
            path.lineTo(0, radiusLeftTop);
            path.quadTo(0, 0, radiusLeftTop, 0);
            canvas.clipPath(path);
            super.onDraw(canvas);
            if (mBorderWidth > 0) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setColor(mBorderColor);
                paint.setStrokeWidth(mBorderWidth);
                canvas.drawPath(path, paint);
            }
            path.close();
        } else {
            super.onDraw(canvas);
        }
    }

}
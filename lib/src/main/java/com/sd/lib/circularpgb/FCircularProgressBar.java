package com.sd.lib.circularpgb;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class FCircularProgressBar extends View
{
    private final Paint mPaint;

    private int mProgress;
    private int mMax = 100;

    private int mNormalColor;
    private int mProgressColor;

    private int mProgressWidth;
    private int mStartAngel;

    public FCircularProgressBar(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        mNormalColor = getResources().getColor(R.color.lib_circular_pgb_normal_color);
        mProgressColor = getResources().getColor(R.color.lib_circular_pgb_progress_color);
        mProgressWidth = getResources().getDimensionPixelSize(R.dimen.lib_circular_pgb_progress_width);
        mStartAngel = getResources().getInteger(R.integer.lib_circular_pgb_start_angel);

        if (attrs != null)
        {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LibCircularProgressBar);

            if (a.hasValue(R.styleable.LibCircularProgressBar_cpgbProgress))
                mProgress = a.getInteger(R.styleable.LibCircularProgressBar_cpgbProgress, mProgress);

            if (a.hasValue(R.styleable.LibCircularProgressBar_cpgbMax))
                mMax = a.getInteger(R.styleable.LibCircularProgressBar_cpgbMax, mMax);

            if (a.hasValue(R.styleable.LibCircularProgressBar_cpgbNormalColor))
                mNormalColor = a.getColor(R.styleable.LibCircularProgressBar_cpgbNormalColor, mNormalColor);

            if (a.hasValue(R.styleable.LibCircularProgressBar_cpgbProgressColor))
                mProgressColor = a.getColor(R.styleable.LibCircularProgressBar_cpgbProgressColor, mProgressColor);

            if (a.hasValue(R.styleable.LibCircularProgressBar_cpgbProgressWidth))
                mProgressWidth = a.getDimensionPixelSize(R.styleable.LibCircularProgressBar_cpgbProgressWidth, mProgressWidth);

            if (a.hasValue(R.styleable.LibCircularProgressBar_cpgbStartAngel))
                mStartAngel = a.getInteger(R.styleable.LibCircularProgressBar_cpgbStartAngel, mStartAngel);

            a.recycle();
        }

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mProgressWidth);
    }

    /**
     * 设置进度值
     *
     * @param progress
     */
    public void setProgress(int progress)
    {
        if (progress < 0)
            progress = 0;

        if (progress > mMax)
            progress = mMax;

        if (mProgress != progress)
        {
            mProgress = progress;
            invalidate();
        }
    }

    /**
     * 设置最大值，默认100
     *
     * @param max
     */
    public void setMax(int max)
    {
        if (max < 0)
            max = 0;

        if (mMax != max)
        {
            mMax = max;

            if (mProgress > mMax)
                setProgress(mMax);
            else
                invalidate();
        }
    }

    /**
     * 设置正常颜色值
     *
     * @param color
     */
    public void setNormalColor(int color)
    {
        if (mNormalColor != color)
        {
            mNormalColor = color;
            invalidate();
        }
    }

    /**
     * 设置进度颜色值
     *
     * @param color
     */
    public void setProgressColor(int color)
    {
        if (mProgressColor != color)
        {
            mProgressColor = color;
            invalidate();
        }
    }

    /**
     * 设置进度条粗细
     *
     * @param width
     */
    public void setProgressWidth(int width)
    {
        if (mProgressWidth != width)
        {
            mProgressWidth = width;
            mPaint.setStrokeWidth(width);
            invalidate();
        }
    }

    /**
     * 设置进度起始角度，默认顶部（-90度）
     *
     * @param angel
     */
    public void setStartAngel(int angel)
    {
        if (mStartAngel != angel)
        {
            mStartAngel = angel;
            invalidate();
        }
    }

    private float getProgressPercent()
    {
        if (mMax == 0)
            return 0f;

        return (float) mProgress / mMax;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        final float width = getWidth() - getPaddingLeft() - getPaddingRight();
        final float height = getHeight() - getPaddingTop() - getPaddingBottom();

        final float x = getWidth() / 2 + (getPaddingLeft() - getPaddingRight()) / 2;
        final float y = getHeight() / 2 + (getPaddingTop() - getPaddingBottom()) / 2;

        final float radius = Math.min(width, height) / 2 - mProgressWidth / 2;
        if (radius > 0)
        {
            final RectF rectF = newRectF(x, y, radius);

            mPaint.setColor(mNormalColor);
            canvas.drawArc(rectF, 0, 360, false, mPaint);

            mPaint.setColor(mProgressColor);
            canvas.drawArc(rectF, mStartAngel, 360 * getProgressPercent(), false, mPaint);
        }
    }

    private static RectF newRectF(float x, float y, float radius)
    {
        final float left = x - radius;
        final float right = x + radius;
        final float top = y - radius;
        final float bottom = y + radius;
        return new RectF(left, top, right, bottom);
    }
}

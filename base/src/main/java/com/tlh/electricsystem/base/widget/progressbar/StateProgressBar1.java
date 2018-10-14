package com.tlh.electricsystem.base.widget.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class StateProgressBar1 extends View {

    private int mCurrentStateNumber;//当前选中状态的位置
    private int mMaxStateNumber;//最大的状态数

    private int mStateBackgroundColor;//状态进度条背景色
    private int mStateForegroundColor;//状态进度条进度颜色

    private Paint mBackgroundPaint;
    private Paint mForegroundPaint;

    private Paint mStateNumberBackgroundPaint;
    private Paint mCurrentStateDescriptionPaint;
    private Paint mStateDescriptionPaint;

    public StateProgressBar1(Context context) {
        super(context);
    }

    public StateProgressBar1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StateProgressBar1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = getHeight();
        int width = MeasureSpec.getSize(widthMeasureSpec);

        setMeasuredDimension(width, height);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public int getCurrentStateNumber() {
        return mCurrentStateNumber;
    }

    public void setCurrentStateNumber(int mCurrentStateNumber) {
        this.mCurrentStateNumber = mCurrentStateNumber;
    }

    public int getMaxStateNumber() {
        return mMaxStateNumber;
    }

    public void setMaxStateNumber(int mMaxStateNumber) {
        this.mMaxStateNumber = mMaxStateNumber;
    }

    public int getmStateBackgroundColor() {
        return mStateBackgroundColor;
    }

    public void setmStateBackgroundColor(int mStateBackgroundColor) {
        this.mStateBackgroundColor = mStateBackgroundColor;
    }

    public int getmStateForegroundColor() {
        return mStateForegroundColor;
    }

    public void setmStateForegroundColor(int mStateForegroundColor) {
        this.mStateForegroundColor = mStateForegroundColor;
    }
}

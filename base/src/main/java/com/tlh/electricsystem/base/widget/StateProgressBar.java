package com.tlh.electricsystem.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.tlh.electricsystem.base.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StateProgressBar extends View {

    private int mCurrentStateNumber=1;//当前选中状态的位置
    private int mMaxStateNumber=3;//最大的状态数
    private float mStatCircleRadius=9;//圆形半径
    private float mLineHeight=2;//进度条线段高度

    private float mStateNumberTextSize = 10;//进度数字字体大小
    private int mStateNumberTextBackgroundColor;//进度数字字体颜色
    private int mStateNumberTextForegroundColor;//进度数字选中字体颜色
    private int mStateDescriptionTextColor;//文字描述字体颜色
    private float mStateDescriptionTextSize = 10;//文字描述字体大小

    private ArrayList<String> mStateDescriptionList = new ArrayList<>();//描述文字

    private int mStateBackgroundColor;//状态进度条背景色
    private int mStateForegroundColor;//状态进度条进度颜色

    private Paint mBackgroundLinePaint;
    private Paint mForegroundLinePaint;

    private Paint mStateNumberPaint;
    private Rect mStateNumberTextRect;//进度字体背景
    private Paint mStateDescriptionPaint;
    private Rect mStateDescriptionTextRect;//描述字体背景

    public StateProgressBar(Context context) {
        super(context);
        init(context,null,0);
    }

    public StateProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs,0);
    }

    public StateProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StateProgressBar, defStyle, 0);

        if (attrs != null) {
            mStateBackgroundColor = a.getColor(R.styleable.StateProgressBar_spb_stateBackgroundColor, mStateBackgroundColor);
            mStateForegroundColor = a.getColor(R.styleable.StateProgressBar_spb_stateForegroundColor, mStateForegroundColor);
            mStateNumberTextBackgroundColor = a.getColor(R.styleable.StateProgressBar_spb_stateNumberBackgroundColor, mStateNumberTextBackgroundColor);
            mStateNumberTextForegroundColor = a.getColor(R.styleable.StateProgressBar_spb_stateNumberForegroundColor, mStateNumberTextForegroundColor);
            mStateDescriptionTextColor= a.getColor(R.styleable.StateProgressBar_spb_currentStateDescriptionColor, mStateDescriptionTextColor);

            mMaxStateNumber = a.getInteger(R.styleable.StateProgressBar_spb_maxStateNumber, mMaxStateNumber);
            mCurrentStateNumber = a.getInteger(R.styleable.StateProgressBar_spb_currentStateNumber, mCurrentStateNumber);
            mStateNumberTextSize = a.getFloat(R.styleable.StateProgressBar_spb_stateTextSize, mStateNumberTextSize);
            mStateDescriptionTextSize = a.getFloat(R.styleable.StateProgressBar_spb_stateDescriptionSize, mStateDescriptionTextSize);
        }

        initPaint();

        a.recycle();
    }

    private void initPaint(){
        mStatCircleRadius = convertDpToPixel(mStatCircleRadius);
        mLineHeight = convertDpToPixel(mLineHeight);

        mBackgroundLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundLinePaint.setColor(getContext().getResources().getColor(R.color.color_divider_grey));

        mForegroundLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mForegroundLinePaint.setColor(getContext().getResources().getColor(R.color.color_theme_green));

        mStateNumberPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mStateNumberPaint.setColor(getContext().getResources().getColor(R.color.color_text_black));
        mStateNumberPaint.setTextSize(convertSpToPixel(10));
        mStateNumberPaint.setStyle(Paint.Style.FILL);
        mStateNumberPaint.setTextAlign(Paint.Align.CENTER);
        mStateNumberTextRect = new Rect();

        mStateDescriptionPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mStateDescriptionPaint.setColor(getContext().getResources().getColor(R.color.color_text_grey));
        mStateDescriptionPaint.setTextSize(convertSpToPixel(10));
        mStateDescriptionPaint.setStyle(Paint.Style.FILL);
        mStateDescriptionPaint.setTextAlign(Paint.Align.CENTER);
        mStateDescriptionTextRect = new Rect();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = getDesireHeight();

        setMeasuredDimension(width, height);
    }

    private int getDesireHeight(){
        if (mStateDescriptionList.isEmpty()) {
            return (int) (2 * mStatCircleRadius);
        } else {
            return (int) (2 * mStatCircleRadius) + (int) convertSpToPixel(20f)+ (int) convertDpToPixel(5);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBackgroundLine(canvas);
        drawForegroundLine(canvas);
        drawBackgroundCircle(canvas);
        drawForegroundCircle(canvas);
        drawStateNumber(canvas);
        drawStateDescription(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private float convertDpToPixel(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return dp * scale;
    }

    private float convertSpToPixel(float sp) {
        final float scale = getResources().getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

    private void drawBackgroundLine(Canvas canvas){
        canvas.drawRect(0,mStatCircleRadius - mLineHeight / 2,getWidth(),mStatCircleRadius + mLineHeight / 2,mBackgroundLinePaint);
    }

    private void drawForegroundLine(Canvas canvas){
        float stateWidth = mCurrentStateNumber * getWidth() / mMaxStateNumber - getWidth() / (2 * mMaxStateNumber) - mStatCircleRadius;
        canvas.drawRect(0,mStatCircleRadius - mLineHeight / 2,stateWidth,mStatCircleRadius + mLineHeight / 2,mForegroundLinePaint);
    }

    private void drawBackgroundCircle(Canvas canvas){
        for(int i = 1;i <= mMaxStateNumber;i++){
            float circleWidth = i * getWidth() / mMaxStateNumber - getWidth() / (2 * mMaxStateNumber);
            canvas.drawCircle(circleWidth,mStatCircleRadius,mStatCircleRadius,mBackgroundLinePaint);
        }
    }

    private void drawForegroundCircle(Canvas canvas){
        for(int i = 1;i <= mCurrentStateNumber;i++){
            int circleWidth = i * getWidth() / mMaxStateNumber - getWidth() / (2 * mMaxStateNumber);
            canvas.drawCircle(circleWidth,mStatCircleRadius,mStatCircleRadius,mForegroundLinePaint);
        }
    }

    private void drawStateNumber(Canvas canvas){
        for(int i = 1;i <= mMaxStateNumber;i++){
            if(i <= mCurrentStateNumber){
                mStateNumberPaint.setColor(Color.WHITE);
            }else {
                mStateNumberPaint.setColor(getContext().getResources().getColor(R.color.color_text_black));
            }
            mStateNumberPaint.setTextSize(convertSpToPixel(10));

            String text = i + "";
            mStateNumberPaint.getTextBounds(text,0,text.length(),mStateNumberTextRect);
            int width = i * getWidth() / mMaxStateNumber - getWidth() / (2 * mMaxStateNumber);

            canvas.drawText(text,width,mStatCircleRadius + mStateNumberTextRect.height() / 2,mStateNumberPaint);
        }
    }

    private void drawStateDescription(Canvas canvas){
        if(mMaxStateNumber != mStateDescriptionList.size()){
            mMaxStateNumber = mStateDescriptionList.size();
        }

        for(int i = 0;i < mStateDescriptionList.size();i++){
            String text = mStateDescriptionList.get(i);
            mStateDescriptionPaint.getTextBounds(text,0,text.length(),mStateDescriptionTextRect);
            int width = (i + 1) * getWidth() / mMaxStateNumber - getWidth() / (2 * mMaxStateNumber);

            canvas.drawText(text,width,2 * mStatCircleRadius + mStateNumberTextRect.height() + convertDpToPixel(4),mStateDescriptionPaint);
        }
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
        invalidate();
    }

    public int getMaxStateNumber() {
        return mMaxStateNumber;
    }

    public void setMaxStateNumber(int mMaxStateNumber) {
        this.mMaxStateNumber = mMaxStateNumber;
        invalidate();
    }

    public int getStateBackgroundColor() {
        return mStateBackgroundColor;
    }

    public void setStateBackgroundColor(int mStateBackgroundColor) {
        this.mStateBackgroundColor = mStateBackgroundColor;
        invalidate();
    }

    public int getStateForegroundColor() {
        return mStateForegroundColor;
    }

    public void setStateForegroundColor(int mStateForegroundColor) {
        this.mStateForegroundColor = mStateForegroundColor;
        invalidate();
    }

    public void setStateDescriptionData(String[] descriptionData){
        mStateDescriptionList.clear();
        mStateDescriptionList.addAll(Arrays.asList(descriptionData));
        mMaxStateNumber = mStateDescriptionList.size();

        invalidate();
        requestLayout();
    }

    public void setStateDescriptionData(List<String> descriptionData){
        if(descriptionData != null){
            mStateDescriptionList.clear();
            mStateDescriptionList.addAll(descriptionData);
            mMaxStateNumber = descriptionData.size();

            invalidate();
            requestLayout();
        }
    }

}

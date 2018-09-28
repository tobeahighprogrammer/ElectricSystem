package com.tlh.electricsystem.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

import java.util.Calendar;

/**
 * Created by zsx on 2018/8/10.
 */

public class BaseRefreshHeader extends LinearLayout implements RefreshHeader {
    private TextView textViewTime, textViewTag;
    private ProgressBar mProgressBar;

    public BaseRefreshHeader(Context context) {
        super(context);
        setGravity(Gravity.CENTER);
//        View view = LayoutInflater.from(context).inflate(R.layout.refresh_header, null, true);
        View view = new View(context);
//        mProgressBar = view.findViewById(R.id.header_img);
//
//        if (android.os.Build.VERSION.SDK_INT > 22) {//android 6.0替换clip的加载动画
//            final Drawable drawable = context.
//                    getApplicationContext().getResources()
//                    .getDrawable(R.drawable.loading_frame_cilp);
//            mProgressBar.setIndeterminateDrawable(drawable);
//        }
//        textViewTime = view.findViewById(R.id.optional_header_time);
//        textViewTag = view.findViewById(R.id.optional_header_tag);
//        textViewTime.setText("最后更新: 今天  " + getHourTime());
        addView(view);
    }

    @NonNull
    @Override
    public View getView() {
        return this;//真实的视图就是自己，不能返回null
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;//指定为平移，不能null
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        if (success) {
            if (textViewTag != null)
                textViewTag.setText("刷新完成");
        } else {
            if (textViewTag != null)
                textViewTag.setText("刷新失败");
        }
        return 200;//延迟500毫秒之后再弹回
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:
                textViewTag.setText("下拉刷新");
                break;
            case Refreshing:
                textViewTag.setText("正在刷新");
                break;
            case ReleaseToRefresh:
                textViewTag.setText("松手立即刷新");
                break;
        }
    }

    public static String getHourTime() {
        String Time;
        Calendar c = Calendar.getInstance();
        int mm = c.get(Calendar.MINUTE);
        if (mm > 9) {
            Time = String.valueOf(c.get(Calendar.HOUR_OF_DAY)) + " : " + String.valueOf(mm);
        } else {
            Time = String.valueOf(c.get(Calendar.HOUR_OF_DAY)) + " : " + "0" + String.valueOf(mm);
        }
        return Time;
    }
}

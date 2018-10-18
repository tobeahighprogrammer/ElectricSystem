package com.tlh.electricsystem.device.viewModel;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.common.ARouterPath;
import com.tlh.electricsystem.device.DeviceContentActivity;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.bean.IntervalBean;

/**
 * Created by Administrator on 2018/10/8 0008.
 */

public class IntervalViewModel extends BaseViewModel {
    private IntervalBean mIntervalBean; //数据源

    public IntervalViewModel(Context mContext) {
        super(mContext);
    }

    //设置列表的监听
    public void addOnItemTouchListener(RecyclerView intervalRecyclerView) {
        intervalRecyclerView.addOnItemTouchListener( new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter , View view , int position ) {
                mIntervalBean = (IntervalBean) adapter.getItem( position ) ;
                //使用fragment
                startActivity(DeviceContentActivity.class);
            }
        });
    }

    //子控件监听
    public void addOnItemChildTouchListener(RecyclerView intervalInfoRecyclerView) {
        intervalInfoRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                mIntervalBean = (IntervalBean) adapter.getItem( position ) ;
                int i = view.getId();
                if (i == R.id.tv_patrol) {
                    //模块化跳转
                    ARouter.getInstance().build(ARouterPath.DeskPatrolProcessActivity).navigation();
                }else if (i == R.id.tv_device_info){
                    startActivity(DeviceContentActivity.class);
                }
            }
        });
    }
}

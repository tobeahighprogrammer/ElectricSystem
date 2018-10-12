package com.tlh.electricsystem.device.viewModel;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.device.DeviceContentActivity;
import com.tlh.electricsystem.device.bean.DeviceInfoBean;
import com.tlh.electricsystem.device.bean.IntervalBean;
import com.tlh.electricsystem.device.fragment.IntervalFragment;

/**
 * Created by Administrator on 2018/10/8 0008.
 */

public class IntervalViewModel extends BaseViewModel {
    private IntervalBean mIntervalBean;
    public IntervalViewModel( Fragment mFragment) {
        super(mFragment);
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
}

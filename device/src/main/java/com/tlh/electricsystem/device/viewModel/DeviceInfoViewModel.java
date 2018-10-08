package com.tlh.electricsystem.device.viewModel;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.device.bean.DeviceInfoBean;
import com.tlh.electricsystem.device.databinding.FragmentDeviceInfoBinding;
import com.tlh.electricsystem.device.fragment.IntervalFragment;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class DeviceInfoViewModel extends BaseViewModel {
    protected DeviceInfoBean mDeviceInfoBean ;
    public DeviceInfoViewModel(Fragment mFragment) {
        super(mFragment);
    }

    //设置列表的监听
    public void addOnItemTouchListener(RecyclerView deviceInfoRecyclerView) {
        deviceInfoRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                mDeviceInfoBean = (DeviceInfoBean) adapter.getItem(position);
                //使用fragment
                startContainerActivity(IntervalFragment.class.getCanonicalName());
            }
        });
    }
}

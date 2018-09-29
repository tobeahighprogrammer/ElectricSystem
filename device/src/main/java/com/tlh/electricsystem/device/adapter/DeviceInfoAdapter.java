package com.tlh.electricsystem.device.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tlh.electricsystem.device.bean.DeviceInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class DeviceInfoAdapter extends BaseQuickAdapter<DeviceInfoBean, BaseViewHolder> {

    public DeviceInfoAdapter(int layoutResId, @Nullable List<DeviceInfoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceInfoBean item) {

    }
}

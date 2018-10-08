package com.tlh.electricsystem.device.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tlh.electricsystem.device.bean.DeviceTaskBean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/30 0030.
 * sj: 2018年9月30日10:36:39
 * name : ts
 * 用途：设备任务详情的适配器做数据展示列表
 */


public class DeviceTaskAdapter extends BaseQuickAdapter<DeviceTaskBean , BaseViewHolder> {

    public DeviceTaskAdapter(int layoutResId, @Nullable List<DeviceTaskBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceTaskBean item) {

    }
}

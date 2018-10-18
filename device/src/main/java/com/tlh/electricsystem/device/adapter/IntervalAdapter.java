package com.tlh.electricsystem.device.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.bean.IntervalBean;

import java.util.List;

/**
 * sj: 2018年10月8日10:03:42
 * name : ts
 * 用途： 展示间隔详情列表适配器
 */
public class IntervalAdapter extends BaseQuickAdapter<IntervalBean , BaseViewHolder> {

    public IntervalAdapter(int layoutResId, @Nullable List<IntervalBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, IntervalBean item) {
        helper.addOnClickListener(R.id.tv_device_info);
        helper.addOnClickListener(R.id.tv_patrol);
    }
}

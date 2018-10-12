package com.tlh.electricsystem.device.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tlh.electricsystem.device.bean.DynamicBean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class DynamicAdapter  extends BaseQuickAdapter<DynamicBean, BaseViewHolder>{

    public DynamicAdapter(int layoutResId, @Nullable List<DynamicBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DynamicBean item) {

    }
}

package com.tlh.electricsystem.device.adapter;

import android.support.annotation.Nullable;
import android.widget.GridView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.bean.ScreenBean;

import java.util.List;

/**
 * sj: 2018年10月16日11:02:53
 * name : ts
 * 用途： 抽屉的布局设配器
 */

public class ScreenAdapter extends BaseQuickAdapter<ScreenBean,BaseViewHolder>{

    public ScreenAdapter(int layoutResId, @Nullable List<ScreenBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ScreenBean item) {
        helper.setText(R.id.tv_operation_name ,item.getName());
        GridView mGridView = helper.getView(R.id.mGridView);
        ScreenGridViewAdapter operationGridViewAdapter = new ScreenGridViewAdapter(mContext , item.getScreenItemBeans());
        mGridView.setAdapter(operationGridViewAdapter);
    }
}

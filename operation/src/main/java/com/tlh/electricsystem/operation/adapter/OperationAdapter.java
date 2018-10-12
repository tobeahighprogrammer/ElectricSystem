package com.tlh.electricsystem.operation.adapter;

import android.support.annotation.Nullable;
import android.widget.GridView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tlh.electricsystem.operation.R;
import com.tlh.electricsystem.operation.bean.OperationBean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class OperationAdapter  extends BaseQuickAdapter<OperationBean ,BaseViewHolder>{

    public OperationAdapter(int layoutResId, @Nullable List<OperationBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OperationBean item) {
        helper.setText(R.id.tv_operation_name ,item.getName());
        GridView mGridView = helper.getView(R.id.mGridView);
        OperationGridViewAdapter operationGridViewAdapter = new OperationGridViewAdapter(mContext , item.getOperationItemBeans());
        mGridView.setAdapter(operationGridViewAdapter);
    }
}

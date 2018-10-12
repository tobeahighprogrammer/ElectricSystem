package com.tlh.electricsystem.operation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tlh.electricsystem.operation.R;
import com.tlh.electricsystem.operation.bean.OperationItemBean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class OperationGridViewAdapter  extends BaseAdapter{
    private Context mContext;
    private List<OperationItemBean> operationItemBeanList;

    public OperationGridViewAdapter(Context mContext, List<OperationItemBean> operationItemBeanList) {
        this.mContext = mContext;
        this.operationItemBeanList = operationItemBeanList;
    }

    @Override
    public int getCount() {
        return operationItemBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return operationItemBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =  LayoutInflater.from(mContext).inflate(R.layout.grid_item_layout,null ,false);
        OperationItemBean operationItemBean = operationItemBeanList.get(position);
        TextView tvGridName  = convertView.findViewById(R.id.tv_grid_name);
        tvGridName.setText(operationItemBean.getName());
        return convertView;
    }
}

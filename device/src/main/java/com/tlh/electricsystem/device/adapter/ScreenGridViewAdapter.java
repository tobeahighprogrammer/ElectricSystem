package com.tlh.electricsystem.device.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.bean.ScreenItemBean;
import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class ScreenGridViewAdapter extends BaseAdapter{
    private Context mContext;
    private List<ScreenItemBean> operationItemBeanList;

    public ScreenGridViewAdapter(Context mContext, List<ScreenItemBean> operationItemBeanList) {
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
        ScreenItemBean screenItemBean = operationItemBeanList.get(position);
        TextView tvGridName  = convertView.findViewById(R.id.tv_screen_value);
        tvGridName.setText(screenItemBean.getValue());
        return convertView;
    }
}

package com.tlh.electricsystem.desk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tlh.electricsystem.desk.R;

/**
 * 组合控件-带设备名称
 */
public class CommonDeviceNameView extends LinearLayout {

    private TextView tvName;
    private TextView tvValue;

    public CommonDeviceNameView(Context context) {
        super(context);
        initView(context);
    }

    public CommonDeviceNameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonDeviceNameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_common_device_name,this,true);

        tvName = findViewById(R.id.tv_common_device_name);
        tvValue = findViewById(R.id.tv_common_device_value);
    }

    public void setName(String name){
        if(tvName != null){
            tvName.setText(name);
        }
    }

    public void setValue(String value){
        if(tvValue != null){
            tvValue.setText(value);
        }
    }
}

package com.tlh.electricsystem.desk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.tlh.electricsystem.desk.R;

/**
 * 组合控件-带单选框
 */
public class CommonWithCheckView extends LinearLayout {

    private TextView tvName;
    private Switch tvValue;

    public CommonWithCheckView(Context context) {
        super(context);
        initView(context);
    }

    public CommonWithCheckView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonWithCheckView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_common_with_check,this,true);

        tvName = findViewById(R.id.tv_common_check_name);
        tvValue = findViewById(R.id.tv_common_check_value);
    }

    public void setName(String name){
        if(tvName != null){
            tvName.setText(name);
        }
    }

    public void setValue(String value){
        if(tvValue != null){
            if("true".endsWith(value)){
                tvValue.setText("是");
                tvValue.setChecked(true);
            }else if("true".endsWith(value)){
                tvValue.setText("否");
                tvValue.setChecked(false);
            }else {
                tvValue.setText("否");
                tvValue.setChecked(false);
            }
        }
    }
}

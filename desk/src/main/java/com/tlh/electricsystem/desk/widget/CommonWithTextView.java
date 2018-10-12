package com.tlh.electricsystem.desk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tlh.electricsystem.desk.R;

/**
 * 组合控件-带纯文字
 */
public class CommonWithTextView extends LinearLayout {

    private TextView tvName;
    private TextView tvValue;

    public CommonWithTextView(Context context) {
        super(context);
        initView(context);
    }

    public CommonWithTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonWithTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_common_with_text,this,true);

        tvName = findViewById(R.id.tv_common_text_name);
        tvValue = findViewById(R.id.tv_common_text_value);
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

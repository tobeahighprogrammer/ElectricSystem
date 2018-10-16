package com.tlh.electricsystem.desk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tlh.electricsystem.desk.R;

/**
 * 组合控件-右边是负责人leader
 */
public class CommonWithLeaderView extends LinearLayout {

    private TextView tvName;
    private TextView tvValue;
    private TextView tvValueTitle;

    public CommonWithLeaderView(Context context) {
        super(context);
        initView(context);
    }

    public CommonWithLeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonWithLeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_common_with_leader,this,true);

        tvName = findViewById(R.id.tv_common_leader_name);
        tvValue = findViewById(R.id.tv_common_leader_member);
        tvValueTitle = findViewById(R.id.tv_common_leader_title);
    }

    public void setName(String name){
        if(tvName != null){
            tvName.setText(name);
        }
    }

    public void setValue(String value){
        if(tvValue != null){
            tvValue.setText(TextUtils.isEmpty(value) ? "未填写" : value);
            tvValueTitle.setText(TextUtils.isEmpty(value) ? "" : value.substring(0,1));
        }
    }
}

package com.tlh.electricsystem.desk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.adapter.TeamMemberAdapter;

import java.util.List;

/**
 * 组合控件-带列表
 */
public class CommonWithListView extends LinearLayout {

    private TextView tvName;
    private TextView tvValue;
    private RecyclerView rvList;

    public CommonWithListView(Context context) {
        super(context);
        initView(context);
    }

    public CommonWithListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonWithListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_common_with_list,this,true);

        tvName = findViewById(R.id.tv_common_list_name);
        tvValue = findViewById(R.id.tv_common_list_value);
        rvList = findViewById(R.id.rv_common_list);
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

    public void setList(List<String> list){
        if(rvList != null){
            TeamMemberAdapter teamMemberAdapter = new TeamMemberAdapter(this.getContext(),list);
            rvList.setLayoutManager(new GridLayoutManager(this.getContext(),2));
            rvList.setAdapter(teamMemberAdapter);
        }
    }
}

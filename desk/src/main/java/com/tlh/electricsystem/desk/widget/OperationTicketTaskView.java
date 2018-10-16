package com.tlh.electricsystem.desk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tlh.electricsystem.desk.R;

/**
 * 操作票任务
 */
public class OperationTicketTaskView extends LinearLayout {

    private TextView tvName;
    private TextView tvValue;

    public OperationTicketTaskView(Context context) {
        super(context);
        initView(context);
    }

    public OperationTicketTaskView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public OperationTicketTaskView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_operation_ticket_task,this,true);

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

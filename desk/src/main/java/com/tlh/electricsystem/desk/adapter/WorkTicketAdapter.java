package com.tlh.electricsystem.desk.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.activity.OperationTicketDetailActivity;
import com.tlh.electricsystem.desk.activity.WorkTicketDetailActivity;
import com.tlh.electricsystem.desk.databinding.ItemOperationTicketBinding;
import com.tlh.electricsystem.desk.databinding.ItemWorkTicketBinding;

import java.util.List;

/**
 * 操作票工作票列表
 */
public class WorkTicketAdapter extends RecyclerView.Adapter<WorkTicketAdapter.BindViewHolder> {

    private Context context;
    private List<String> dataList;

    public WorkTicketAdapter(Context context, List<String> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public BindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_work_ticket,parent,false);
        return new BindViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindViewHolder holder, int position) {
        ItemWorkTicketBinding binding = (ItemWorkTicketBinding)holder.getBinding();

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, WorkTicketDetailActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class BindViewHolder extends RecyclerView.ViewHolder{
        private ViewDataBinding binding;
        public BindViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}

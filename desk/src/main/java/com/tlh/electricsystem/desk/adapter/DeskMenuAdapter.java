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
import com.tlh.electricsystem.desk.activity.DeskPatrolContentActivity;
import com.tlh.electricsystem.desk.activity.DeskPatrolDetailActivity;
import com.tlh.electricsystem.desk.activity.DeskPatrolProcessActivity;
import com.tlh.electricsystem.desk.activity.OperationTicketListActivity;
import com.tlh.electricsystem.desk.activity.WorkTicketListActivity;
import com.tlh.electricsystem.desk.databinding.ItemDeskMenuBinding;

import java.util.List;

public class DeskMenuAdapter extends RecyclerView.Adapter<DeskMenuAdapter.BindViewHolder> {

    private Context context;
    private List<String> dataList;

    public DeskMenuAdapter(Context context,List<String> dataList){
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public BindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_desk_menu,parent,false);
        return new BindViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindViewHolder holder, final int position) {
        ItemDeskMenuBinding binding = (ItemDeskMenuBinding)holder.getBinding();
        String name = dataList.get(position);
        binding.tvDeskMenu.setText(name);
        binding.ivDeskMenu.setImageResource(R.mipmap.ic_launcher);

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0){
                    context.startActivity(new Intent(context, DeskPatrolProcessActivity.class));
                }

                if(position == 1){
                    context.startActivity(new Intent(context, DeskPatrolDetailActivity.class));
                }

                if(position == 2){
                    context.startActivity(new Intent(context, DeskPatrolContentActivity.class));
                }

                if(position == 3){
                    context.startActivity(new Intent(context, OperationTicketListActivity.class));
                }

                if(position == 4){
                    context.startActivity(new Intent(context, WorkTicketListActivity.class));
                }
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

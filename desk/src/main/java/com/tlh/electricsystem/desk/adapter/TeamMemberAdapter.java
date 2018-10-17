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
import com.tlh.electricsystem.desk.databinding.ItemPatrolTeamMemberBinding;

import java.util.List;

public class TeamMemberAdapter extends RecyclerView.Adapter<TeamMemberAdapter.BindViewHolder> {

    private Context context;
    private List<String> dataList;

    public TeamMemberAdapter(Context context, List<String> dataList){
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public BindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_patrol_team_member,parent,false);
        return new BindViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindViewHolder holder, final int position) {
        ItemPatrolTeamMemberBinding binding = (ItemPatrolTeamMemberBinding)holder.getBinding();
        String name = dataList.get(position);
        binding.tvTeamMemberTitle.setText(name.substring(0,1));
        binding.tvTeamMemberName.setText(name);

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

package com.tlh.electricsystem.desk.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ItemPatrolDeviceBinding;
import com.tlh.electricsystem.desk.databinding.ItemPatrolDeviceFaultBinding;

import java.util.List;

/**
 * 巡视设备-缺陷设备
 */
public class PatrolDeviceFaultAdapter extends RecyclerView.Adapter<PatrolDeviceFaultAdapter.BindViewHolder> {

    private Context context;
    private List<String> dataList;

    public PatrolDeviceFaultAdapter(Context context, List<String> dataList){
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public BindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_patrol_device_fault,parent,false);
        return new BindViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindViewHolder holder, int position) {
        ItemPatrolDeviceFaultBinding binding = (ItemPatrolDeviceFaultBinding) holder.getBinding();

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

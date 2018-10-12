package com.tlh.electricsystem.desk.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ItemPatrolContentBinding;
import com.tlh.electricsystem.desk.databinding.ItemPatrolDeviceBinding;

import java.util.Arrays;
import java.util.List;

/**
 * 巡视设备
 */
public class PatrolDeviceAdapter extends RecyclerView.Adapter<PatrolDeviceAdapter.BindViewHolder> {

    private Context context;
    private List<String> dataList;

    public PatrolDeviceAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public BindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_patrol_device, parent, false);
        return new BindViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindViewHolder holder, int position) {
        ItemPatrolDeviceBinding binding = (ItemPatrolDeviceBinding) holder.getBinding();
        binding.rvPatrolDeviceFault.setLayoutManager(new GridLayoutManager(context, 5));
        PatrolDeviceFaultAdapter deviceFaultAdapter = new PatrolDeviceFaultAdapter(context,Arrays.asList("","","","",""));
        binding.rvPatrolDeviceFault.setAdapter(deviceFaultAdapter);

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

    class BindViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}

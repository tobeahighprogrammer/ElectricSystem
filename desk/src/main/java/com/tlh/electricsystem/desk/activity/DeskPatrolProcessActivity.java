package com.tlh.electricsystem.desk.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityDeskPatrolProcessBinding;
import com.tlh.electricsystem.desk.widget.CommonDeviceNameView;
import com.tlh.electricsystem.desk.widget.CommonWithCheckView;
import com.tlh.electricsystem.desk.widget.CommonWithNextView;
import com.tlh.electricsystem.desk.widget.CommonWithSelectorView;

/**
 * 巡视流程页面
 */
public class DeskPatrolProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDeskPatrolProcessBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_desk_patrol_process);

//        CommonDeviceNameView commonDeviceNameView = new CommonDeviceNameView(this);
//        LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) commonDeviceNameView.getLayoutParams();
//        layoutParams1.topMargin = DimensionUtil.dip2px(this,10);
//        binding.llItemContainer.addView(commonDeviceNameView);
//
//        CommonWithNextView commonWithNextView = new CommonWithNextView(this);
//        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) commonWithNextView.getLayoutParams();
//        layoutParams2.topMargin = DimensionUtil.dip2px(this,10);
//        binding.llItemContainer.addView(commonWithNextView);

        String[] descriptionData = {"提交基本信息", "提交数据抄录", "提交巡视结果"};
        binding.spbPatrolProgress.setStateDescriptionData(descriptionData);


        binding.llItemContainer.addView(new CommonDeviceNameView(this));
        binding.llItemContainer.addView(new CommonWithNextView(this));
        binding.llItemContainer.addView(new CommonWithSelectorView(this));
        binding.llItemContainer.addView(new CommonWithCheckView(this));
    }
}

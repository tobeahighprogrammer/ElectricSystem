package com.tlh.electricsystem.desk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.common.ARouterPath;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityDeskPatrolProcessBinding;
import com.tlh.electricsystem.desk.widget.CommonDeviceNameView;
import com.tlh.electricsystem.desk.widget.CommonWithCheckView;
import com.tlh.electricsystem.desk.widget.CommonWithNextView;
import com.tlh.electricsystem.desk.widget.CommonWithSelectorView;
import com.tlh.electricsystem.desk.widget.CommonWithTextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * 巡视流程页面
 */
@Route(path = ARouterPath.DeskPatrolProcessActivity)
public class DeskPatrolProcessActivity extends BaseActivity<ActivityDeskPatrolProcessBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_desk_patrol_process;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public BaseViewModel initViewModel() {
        return new BaseViewModel(this);
    }

    @Override
    public void initData() {
        super.initData();

        mBinding.btnPatrolSubmitComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeskPatrolProcessActivity.this,DeskPatrolCompleteActivity.class));
            }
        });

        String[] descriptionData = {"提交基本信息", "提交数据抄录", "提交巡视结果"};
        mBinding.spbPatrolProgress.setStateDescriptionData(descriptionData);

        addChildView(testJson,mBinding.llItemContainer);
    }

    private static String testJson = " {" +
            "\"title\": { " +
            "\"name\": \"设备名称\"," +
            "\"value\":\"220V\"," +
            "\"type\":\"deviceTitle\"}," +

            "\"result\": { " +
            "\"name\": \"巡视结果\"," +
            "\"value\":\"\"," +
            "\"type\":\"next\"},"+

            "\"content\": { " +
            "\"name\": \"巡视内容\"," +
            "\"value\":\"\"," +
            "\"type\":\"next\"},"+

            "\"startTime\": { " +
            "\"name\": \"巡视开始时间\"," +
            "\"value\":\"\"," +
            "\"type\":\"selector\"},"+

            "\"endTime\": { " +
            "\"name\": \"巡视结束时间\"," +
            "\"value\":\"\"," +
            "\"type\":\"selector\"},"+

            "\"isFault\": { " +
            "\"name\": \"存在缺陷\"," +
            "\"value\":\"false\"," +
            "\"type\":\"check\"},"+

            "\"isTrouble\": { " +
            "\"name\": \"存在隐患\"," +
            "\"value\":\"true\"," +
            "\"type\":\"check\"}"+
            " }";

    private void addChildView(String testJson, LinearLayout radioGroup){
        try {
            JSONObject jsonObject = new JSONObject(testJson);
            Iterator iterator =jsonObject.keys();
            while (iterator.hasNext()) {
                JSONObject childJsonObject = jsonObject.getJSONObject(iterator.next().toString());
                if(childJsonObject.has("type")) {
                    String type = childJsonObject.getString("type");
                    switch (type) {
                        case "deviceTitle":
                            CommonDeviceNameView commonDeviceNameView = new CommonDeviceNameView(this);
                            commonDeviceNameView.setName(childJsonObject.getString("name"));
                            commonDeviceNameView.setValue(childJsonObject.getString("value"));
                            radioGroup.addView(commonDeviceNameView);
                            break;
                        case "text":
                            CommonWithTextView commonWithTextView = new CommonWithTextView(this);
                            commonWithTextView.setName(childJsonObject.getString("name"));
                            commonWithTextView.setValue(childJsonObject.getString("value"));
                            radioGroup.addView(commonWithTextView);
                            break;
                        case "next":
                            CommonWithNextView commonWithNextView = new CommonWithNextView(this);
                            commonWithNextView.setName(childJsonObject.getString("name"));
                            commonWithNextView.setValue(childJsonObject.getString("value"));
                            radioGroup.addView(commonWithNextView);
                            break;
                        case "check":
                            CommonWithCheckView commonWithCheckView = new CommonWithCheckView(this);
                            commonWithCheckView.setName(childJsonObject.getString("name"));
                            commonWithCheckView.setValue(childJsonObject.getString("value"));
                            radioGroup.addView(commonWithCheckView);
                            break;
                        case "selector":
                            CommonWithSelectorView commonWithSelectorView = new CommonWithSelectorView(this);
                            commonWithSelectorView.setName(childJsonObject.getString("name"));
                            commonWithSelectorView.setValue(childJsonObject.getString("value"));
                            radioGroup.addView(commonWithSelectorView);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

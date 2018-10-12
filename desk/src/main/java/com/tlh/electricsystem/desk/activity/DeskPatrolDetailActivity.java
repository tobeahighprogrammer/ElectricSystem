package com.tlh.electricsystem.desk.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityDeskPatrolDetailBinding;
import com.tlh.electricsystem.desk.widget.CommonDeviceNameView;
import com.tlh.electricsystem.desk.widget.CommonWithCheckView;
import com.tlh.electricsystem.desk.widget.CommonWithListView;
import com.tlh.electricsystem.desk.widget.CommonWithNextView;
import com.tlh.electricsystem.desk.widget.CommonWithSelectorView;
import com.tlh.electricsystem.desk.widget.CommonWithTextView;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 巡视作业详情页面
 */
public class DeskPatrolDetailActivity extends BaseActivity<ActivityDeskPatrolDetailBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_desk_patrol_detail;
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
        addChildView(testJson,mBinding.llPatrolDetailContainer);
    }

    private static String testJson = " {" +
            "\"leader\": { " +
            "\"name\": \"负责人\"," +
            "\"value\":\"\"," +
            "\"type\":\"selector\"}," +

            "\"startTime\": { " +
            "\"name\": \"实际开始时间\"," +
            "\"value\":\"\"," +
            "\"type\":\"selector\"},"+

            "\"endTime\": { " +
            "\"name\": \"实际结束时间\"," +
            "\"value\":\"\"," +
            "\"type\":\"selector\"},"+

            "\"team\": { " +
            "\"name\": \"工作成员\"," +
            "\"value\":\"4人\"," +
            "\"type\":\"list\"},"+

            "\"isDelay\": { " +
            "\"name\": \"是否超期\"," +
            "\"value\":\"false\"," +
            "\"type\":\"check\"},"+

            "\"reason\": { " +
            "\"name\": \"超期原因\"," +
            "\"value\":\"\"," +
            "\"type\":\"next\"},"+

            "\"prompt\": { " +
            "\"name\": \"备注\"," +
            "\"value\":\"\"," +
            "\"type\":\"next\"}"+
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
                        case "list":
                            CommonWithListView commonWithListView = new CommonWithListView(this);
                            commonWithListView.setName(childJsonObject.getString("name"));
                            commonWithListView.setValue(childJsonObject.getString("value"));
                            commonWithListView.setList(Arrays.asList("Michael","Jack","Rose","Peter"));
                            radioGroup.addView(commonWithListView);
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

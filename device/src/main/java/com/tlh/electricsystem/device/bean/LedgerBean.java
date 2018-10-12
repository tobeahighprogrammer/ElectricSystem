package com.tlh.electricsystem.device.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class LedgerBean implements MultiItemEntity {
    private int type;
    private String name ="" ;
    private String value = "";

    public LedgerBean(int type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LedgerBean(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}

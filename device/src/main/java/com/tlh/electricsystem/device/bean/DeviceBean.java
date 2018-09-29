package com.tlh.electricsystem.device.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class DeviceBean implements MultiItemEntity {
    private int type;

    public DeviceBean(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}

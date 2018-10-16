package com.tlh.electricsystem.device.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16 0016.
 */

public class ScreenBean {
    private String name;
    private List<ScreenItemBean> screenItemBeans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScreenItemBean> getScreenItemBeans() {
        return screenItemBeans;
    }

    public void setScreenItemBeans(List<ScreenItemBean> screenItemBeans) {
        this.screenItemBeans = screenItemBeans;
    }
}

package com.tlh.electricsystem.operation.bean;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class OperationItemBean {
    private String url ;
    private String name;

    public OperationItemBean() {
    }

    public OperationItemBean(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

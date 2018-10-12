package com.tlh.electricsystem.operation.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class OperationBean {
    private String name ;
    private List<OperationItemBean> operationItemBeans;

    public OperationBean(String name, List<OperationItemBean> operationItemBeans) {
        this.name = name;
        this.operationItemBeans = operationItemBeans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OperationItemBean> getOperationItemBeans() {
        return operationItemBeans;
    }

    public void setOperationItemBeans(List<OperationItemBean> operationItemBeans) {
        this.operationItemBeans = operationItemBeans;
    }
}

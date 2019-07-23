package com.web.core.pojo;

import java.util.Date;

public class Statistics {
    private Integer id;

    private Date day;

    private Integer orderNum;

    private Integer serviceNum;

    private Integer newUserNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(Integer serviceNum) {
        this.serviceNum = serviceNum;
    }

    public Integer getNewUserNum() {
        return newUserNum;
    }

    public void setNewUserNum(Integer newUserNum) {
        this.newUserNum = newUserNum;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", day=" + day +
                ", orderNum=" + orderNum +
                ", serviceNum=" + serviceNum +
                ", newUserNum=" + newUserNum +
                '}';
    }
}
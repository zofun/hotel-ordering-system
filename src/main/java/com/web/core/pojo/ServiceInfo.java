package com.web.core.pojo;

import java.util.Date;

public class ServiceInfo {

    private Integer id;

    private String serviceMsg;

    private Date time;

    private String name;

    private String status;

    private String roomNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceMsg() {
        return serviceMsg;
    }

    public void setServiceMsg(String serviceMsg) {
        this.serviceMsg = serviceMsg;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "id=" + id +
                ", serviceMsg='" + serviceMsg + '\'' +
                ", time=" + time +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", roomNo='" + roomNo + '\'' +
                '}';
    }
}

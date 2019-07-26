package com.web.core.pojo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/7/26
 * @Description: com.web.core.pojo
 * @versio: 1.0
 */
public class OrderInfo {
    private Integer id;
    private String roomNo;
    private String status;
    private String roomType;

    private Date orderTime;
    private Date time;
    private Date checkInTime;
    private Date checkOutTime;

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public OrderInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", roomNo='" + roomNo + '\'' +
                ", roomType='" + roomType + '\'' +
                ", status='" + status + '\'' +
                ", orderTime=" + orderTime +
                ", time=" + time +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                '}';
    }

    public OrderInfo(Integer id, String roomNo, String roomType, String status, Date orderTime, Date time, Date checkInTime, Date checkOutTime) {
        this.id = id;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.status = status;
        this.orderTime = orderTime;
        this.time = time;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
}

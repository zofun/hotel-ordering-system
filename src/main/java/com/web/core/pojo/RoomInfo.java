package com.web.core.pojo;

public class RoomInfo {
    private Integer id;

    private String roomNo;

    private String status;

    private String roomType;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "id=" + id +
                ", roomNo='" + roomNo + '\'' +
                ", status='" + status + '\'' +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}

package com.web.core.pojo;

/**
 * 用于封装推荐列表信息
 */
public class TipInfo {
    //房间类型id
    private Integer id;
    private String roomType;
    private String desc;
    private String descUrl;
    private Integer capacity;
    private String price;
    private Integer num;
    private String hotelName;
    private String hotelId;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescUrl() {
        return descUrl;
    }

    public void setDescUrl(String descUrl) {
        this.descUrl = descUrl;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "TipInfo{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", desc='" + desc + '\'' +
                ", descUrl='" + descUrl + '\'' +
                ", capacity=" + capacity +
                ", price='" + price + '\'' +
                ", num=" + num +
                ", hotelName='" + hotelName + '\'' +
                ", hotelId='" + hotelId + '\'' +
                '}';
    }
}

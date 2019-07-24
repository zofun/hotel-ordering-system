package com.web.core.pojo;


/**
 * @author TCW
 */
public class RoomTypeInfo {

    private Integer id;

    private String roomType;

    private String price;

    private Integer num;

    private String subbranch;

    private String desc;

    private String descUrl;

    private String isrecommend;

    private Integer capacity;

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

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
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

    public String getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(String isrecommend) {
        this.isrecommend = isrecommend;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "RoomTypeInfo{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", price='" + price + '\'' +
                ", num=" + num +
                ", subbranch='" + subbranch + '\'' +
                ", desc='" + desc + '\'' +
                ", descUrl='" + descUrl + '\'' +
                ", isrecommend='" + isrecommend + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

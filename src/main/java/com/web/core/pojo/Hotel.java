package com.web.core.pojo;

/**
 * @author TCW
 */
public class Hotel {
    private Integer id;

    private String hotelName;

    private String subbranch;

    private String starLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch == null ? null : subbranch.trim();
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel == null ? null : starLevel.trim();
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", subbranch='" + subbranch + '\'' +
                ", starLevel='" + starLevel + '\'' +
                '}';
    }
}
package com.web.core.pojo;


/**
 * @author TCW
 */
public class User {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String salt;

    private Integer hotel;

    private String isadmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getHotel() {
        return hotel;
    }

    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", hotel=" + hotel +
                ", isadmin='" + isadmin + '\'' +
                '}';
    }
}
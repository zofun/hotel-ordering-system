package com.web.core.pojo;

import java.util.List;

public class RoleInfo {

    private Integer id;
    private String roleMsg;
    private String roleName;


    private String manRoomType=" ";
    private String readRoom=" ";
    private String manRoom=" ";
    private String readSignIn=" ";
    private String manSignIn=" ";
    private String manRole=" ";
    private String roleAllo=" ";
    private String readService=" ";
    private String manService=" ";


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleMsg() {
        return roleMsg;
    }

    public void setRoleMsg(String roleMsg) {
        this.roleMsg = roleMsg;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getManRoomType() {
        return manRoomType;
    }

    public void setManRoomType(String manRoomType) {
        this.manRoomType = manRoomType;
    }

    public String getReadRoom() {
        return readRoom;
    }

    public void setReadRoom(String readRoom) {
        this.readRoom = readRoom;
    }

    public String getManRoom() {
        return manRoom;
    }

    public void setManRoom(String manRoom) {
        this.manRoom = manRoom;
    }

    public String getReadSignIn() {
        return readSignIn;
    }

    public void setReadSignIn(String readSignIn) {
        this.readSignIn = readSignIn;
    }

    public String getManSignIn() {
        return manSignIn;
    }

    public void setManSignIn(String manSignIn) {
        this.manSignIn = manSignIn;
    }

    public String getManRole() {
        return manRole;
    }

    public void setManRole(String manRole) {
        this.manRole = manRole;
    }

    public String getRoleAllo() {
        return roleAllo;
    }

    public void setRoleAllo(String roleAllo) {
        this.roleAllo = roleAllo;
    }

    public String getReadService() {
        return readService;
    }

    public void setReadService(String readService) {
        this.readService = readService;
    }

    public String getManService() {
        return manService;
    }

    public void setManService(String manService) {
        this.manService = manService;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "id=" + id +
                ", roleMsg='" + roleMsg + '\'' +
                ", roleName='" + roleName + '\'' +
                ", manRoomType='" + manRoomType + '\'' +
                ", readRoom='" + readRoom + '\'' +
                ", manRoom='" + manRoom + '\'' +
                ", readSignIn='" + readSignIn + '\'' +
                ", manSignIn='" + manSignIn + '\'' +
                ", manRole='" + manRole + '\'' +
                ", roleAllo='" + roleAllo + '\'' +
                ", readService='" + readService + '\'' +
                ", manService='" + manService + '\'' +
                '}';
    }
}

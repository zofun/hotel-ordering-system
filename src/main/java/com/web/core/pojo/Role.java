package com.web.core.pojo;


/**
 * @author TCW
 */
public class Role {
    private Integer id;

    private String roleName;

    private String roleMsg;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleMsg() {
        return roleMsg;
    }

    public void setRoleMsg(String roleMsg) {
        this.roleMsg = roleMsg == null ? null : roleMsg.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleMsg='" + roleMsg + '\'' +
                ", userId=" + userId +
                '}';
    }
}
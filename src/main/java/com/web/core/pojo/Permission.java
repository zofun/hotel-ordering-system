package com.web.core.pojo;

/**
 * @author TCW
 */
public class Permission {
    private Integer id;

    private String potence;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPotence() {
        return potence;
    }

    public void setPotence(String potence) {
        this.potence = potence == null ? null : potence.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "PermissionMapper{" +
                "id=" + id +
                ", potence='" + potence + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
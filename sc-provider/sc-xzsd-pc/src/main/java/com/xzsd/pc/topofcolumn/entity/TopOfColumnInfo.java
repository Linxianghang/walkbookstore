package com.xzsd.pc.topofcolumn.entity;

/**
 * 顶部栏实体类
 * @author linxianghang
 * @date 2020-04-19
 */
public class TopOfColumnInfo {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userImage;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户角色（0超级管理员，1管理员，2店长）
     */
    private String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

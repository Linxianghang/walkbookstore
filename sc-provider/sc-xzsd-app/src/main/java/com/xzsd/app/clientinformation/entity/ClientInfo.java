package com.xzsd.app.clientinformation.entity;

/**
 * 修改邀请码实体类
 * @author linxianghang
 * @date 2020-04-27
 */
public class ClientInfo {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 邀请码
     */
    private String inviteCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}

package com.xzsd.pc.store.entity;

/**
 * StoreVO
 * @author linxianghang
 * @date 2020-04-16
 */
public class StoreVO {
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 店长编码
     */
    private String userId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 营业执照编码
     */
    private String businessCode;
    /**
     * 店长名称
     */
    private String userName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邀请码
     */
    private String inviteCode;
    /**
     * 门店账号
     */
    private String userAcct;
    /**
     * 省名
     */
    private String provinceName;
    /**
     * 城市名
     */
    private String cityName;
    /**
     * 区县名
     */
    private String areaName;
    /**
     * 地址
     */
    private String address;
    /**
     * 版本号
     */
    private String version;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

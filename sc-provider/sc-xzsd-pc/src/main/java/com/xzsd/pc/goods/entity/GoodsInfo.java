package com.xzsd.pc.goods.entity;


import java.util.Date;

/**
 * 商品管理
 * @author linxianghang
 * @date 2020-04-10
 */

public class GoodsInfo {
    /**
     * 商品库存(对应商品编号，逗号隔开)
     */
    private String goodsInventories;
    /**
     *商品图片
     */
    private String goodsImagePath;
    /**
     * 商品上架时间
     */
    private String goodsShelfTime;
    /**
     * 商品浏览量
     */
    private int goodsViewsNum;
    /**
     *销售量
     */
    private int goodsSales;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 版本号
     */
    private String version;
    /**
     * 分类编号(一级分类传0，二级分类传选中的一级分类的编号)
     */
    private String classifyId;
    /**
     * 商品分类名称
     */
    private String classifyName;
    /**
     * 书编码
     */
    private String goodsId;
    /**
     * 书名
     */
    private String goodsName;
    /**
     * 书号
     */
    private String isbn;
    /**
     * 一级分类编号
     */
    private String oneClassifyId;
    /**
     * 二级分类编号
     */
    private String twoClassifyId;
    /**
     *一级分类名称
     */
    private String oneClassifyName;
    /**
     *二级分类名称
     */
    private String twoClassifyName;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 商家名称
     */
    private String supplierName;
    /**
     * 商品库存
     */
    private int goodsInventory;
    /**
     * 成本价
     */
    private double goodsOriginalCost;
    /**
     * 在售价
     */
    private double goodsPrice;
    /**
     * 广告词
     */
    private String goodsAdvertise;
    /**
     * 商品图片路径
     */
    private String imagePath;
    /**
     * 作者
     */
    private String goodsAuthor;
    /**
     * 出版社
     */
    private String goodsPress;
    /**
     * 商品状态编号
     * （根据以下规则变化：
     * 按钮名称[改成的状态编号]，
     */
    private  String goodsStateId;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOneClassifyId() {
        return oneClassifyId;
    }

    public void setOneClassifyId(String oneClassifyId) {
        this.oneClassifyId = oneClassifyId;
    }

    public String getTwoClassifyId() {
        return twoClassifyId;
    }

    public void setTwoClassifyId(String twoClassifyId) {
        this.twoClassifyId = twoClassifyId;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public double getGoodsOriginalCost() {
        return goodsOriginalCost;
    }

    public void setGoodsOriginalCost(double goodsOriginalCost) {
        this.goodsOriginalCost = goodsOriginalCost;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsAdvertise() {
        return goodsAdvertise;
    }

    public void setGoodsAdvertise(String goodsAdvertise) {
        this.goodsAdvertise = goodsAdvertise;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getOneClassifyName() {
        return oneClassifyName;
    }

    public void setOneClassifyName(String oneClassifyName) {
        this.oneClassifyName = oneClassifyName;
    }

    public String getTwoClassifyName() {
        return twoClassifyName;
    }

    public void setTwoClassifyName(String twoClassifyName) {
        this.twoClassifyName = twoClassifyName;
    }

    public String getGoodsStateId() {
        return goodsStateId;
    }

    public void setGoodsStateId(String goodsStateId) {
        this.goodsStateId = goodsStateId;
    }

    public int getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(int goodsSales) {
        this.goodsSales = goodsSales;
    }

    public String getGoodsShelfTime() {
        return goodsShelfTime;
    }

    public void setGoodsShelfTime(String goodsShelfTime) {
        this.goodsShelfTime = goodsShelfTime;
    }

    public int getGoodsViewsNum() {
        return goodsViewsNum;
    }

    public void setGoodsViewsNum(int goodsViewsNum) {
        this.goodsViewsNum = goodsViewsNum;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsInventories() {
        return goodsInventories;
    }

    public void setGoodsInventories(String goodsInventories) {
        this.goodsInventories = goodsInventories;
    }
}

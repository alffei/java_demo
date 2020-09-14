package com.gd.lambda.bean;

/**
 * 单品
 *
 * @author chenpengfei
 */
public class Sku {

    /**
     * 商品编号
     */
    private Integer skuId;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 单价
     */
    private Double skuPrice;

    /**
     * 总数
     */
    private Integer totalNum;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 商品类型
     */
    private Enum skuCateGory;


    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, Enum skuCateGory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.skuCateGory = skuCateGory;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Double skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Enum getSkuCateGory() {
        return skuCateGory;
    }

    public void setSkuCateGory(Enum skuCateGory) {
        this.skuCateGory = skuCateGory;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", skuPrice=" + skuPrice +
                ", totalNum=" + totalNum +
                ", totalPrice=" + totalPrice +
                ", skuCateGory=" + skuCateGory +
                '}';
    }
}

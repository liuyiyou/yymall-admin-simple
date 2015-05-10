package cn.liuyiyou.yishop.entity;

import java.math.BigDecimal;

public class Product extends BaseEntity {

    private String channel;

    private String category;

    private String prodId;

    private String prodName;

    private String price;

    private String discountPrice;

    private String discount;

    private String merName;

    private String detailLink;

    private String recommendReason;

    private String prodPic;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceForShow() {
        return price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDiscountPriceForShow() {
        return discountPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public float getDiscountForShow() {
        return (new BigDecimal(discount).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100))).floatValue() / 10f;
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName;
    }

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(String recommendReason) {
        this.recommendReason = recommendReason;
    }

    public String getProdPic() {
        return prodPic;
    }

    public void setProdPic(String prodPic) {
        this.prodPic = prodPic;
    }

}

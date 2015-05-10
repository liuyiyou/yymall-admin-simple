package cn.liuyiyou.yishop.entity;


/**
 * 购物车
 * @author liuyiyou
 *
 */
public class Cart extends BaseEntity {

    private int    userId;

    private String sid;

    private int    productId;

    private int    quality;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSid() {
        return sid;
    }

    /**
     * Setter method for property <tt>sid</tt>.
     * 
     * @param sid value to be assigned to property sid
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * Getter method for property <tt>productId</tt>.
     * 
     * @return property value of productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Setter method for property <tt>productId</tt>.
     * 
     * @param productId value to be assigned to property productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Getter method for property <tt>quality</tt>.
     * 
     * @return property value of quality
     */
    public int getQuality() {
        return quality;
    }

    /**
     * Setter method for property <tt>quality</tt>.
     * 
     * @param quality value to be assigned to property quality
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }

}

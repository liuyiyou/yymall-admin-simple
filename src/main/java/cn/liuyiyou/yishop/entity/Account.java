package cn.liuyiyou.yishop.entity;


import cn.liuyiyou.yishop.common.util.constansts.AccountConstants;

public class Account extends BaseEntity {

    private int    userId;

    private String acctType   = AccountConstants.ACCT_TYPE_BASEDT;

    private String capType    = AccountConstants.CAP_TYPE_CASH;

    private String curyType   = AccountConstants.CURY_TYPE_CNY;

    private String acctName;

    private int    acctBal;

    private int    avlBal;

    private int    frzBal;

    private String acctStatus = AccountConstants.ACCT_STATUS_NORMAL;

   
    public int getUserId() {
        return userId;
    }

  
    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    public String getAcctType() {
        return acctType;
    }

    
    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    
    public String getCapType() {
        return capType;
    }

    
    public void setCapType(String capType) {
        this.capType = capType;
    }

    
    public String getCuryType() {
        return curyType;
    }

    
    public void setCuryType(String curyType) {
        this.curyType = curyType;
    }

    
    public String getAcctName() {
        return acctName;
    }

    
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    
    public int getAcctBal() {
        return acctBal;
    }

    
    public void setAcctBal(int acctBal) {
        this.acctBal = acctBal;
    }

   
    public int getAvlBal() {
        return avlBal;
    }

   
    public void setAvlBal(int avlBal) {
        this.avlBal = avlBal;
    }

   
    public int getFrzBal() {
        return frzBal;
    }

   
    public void setFrzBal(int frzBal) {
        this.frzBal = frzBal;
    }

   
    public String getAcctStatus() {
        return acctStatus;
    }

   
    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

}

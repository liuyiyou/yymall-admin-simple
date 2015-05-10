/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.entity;

import java.util.Date;

public class LoginInfo extends BaseEntity {

    private int    userId;

    private String userName;

    private String loginType;

    private String password;

    private Date   lastLoginTime;

    
    public int getUserId() {
        return userId;
    }

   
    public void setUserId(int userId) {
        this.userId = userId;
    }

 
    public String getUserName() {
        return userName;
    }

  
    public void setUserName(String userName) {
        this.userName = userName;
    }

   
    public String getLoginType() {
        return loginType;
    }

    /**
     * Setter method for property <tt>loginType</tt>.
     * 
     * @param loginType value to be assigned to property loginType
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    /**
     * Getter method for property <tt>password</tt>.
     * 
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     * 
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property <tt>lastLoginTime</tt>.
     * 
     * @return property value of lastLoginTime
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * Setter method for property <tt>lastLoginTime</tt>.
     * 
     * @param lastLoginTime value to be assigned to property lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

}

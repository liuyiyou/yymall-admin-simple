/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.entity.Account;
import cn.liuyiyou.yishop.mapper.AccountMapper;
import cn.liuyiyou.yishop.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yaofang
 * @version $Id: AccountService.java, v 0.1 2014年10月5日 上午8:18:40 yaofang Exp $
 */
@Service
public class AccountService extends BaseSevice {

    @Autowired
    private AccountMapper accountMapper;

    public Account findAccountInfoByUserIdAndAcctType(int userId, String acctType) {
        return accountMapper.queryByUserIdAndAcctType(userId, acctType);
    }

    public Account findAndLockAccountInfoByUserIdAndAcctType(int userId, String acctType) {
        return accountMapper.queryAndLockByUserIdAndAcctType(userId, acctType);
    }

    public void modifyAccountBal(Account account) {
        accountMapper.updateAccountBal(account);
    }

    /** 
     */
    @Override
    protected BaseMapper getMapper() {
        return accountMapper;
    }

}

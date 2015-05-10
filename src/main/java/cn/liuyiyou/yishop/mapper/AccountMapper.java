package cn.liuyiyou.yishop.mapper;

import cn.liuyiyou.yishop.entity.Account;
import org.apache.ibatis.annotations.Param;


/**
 * 
 */
public interface AccountMapper extends BaseMapper {

    public Account queryByUserIdAndAcctType(@Param("userId") int userId, @Param("acctType") String acctType);

    public Account queryAndLockByUserIdAndAcctType(@Param("userId") int userId, @Param("acctType") String acctType);

    public void updateAccountBal(Account account);

}

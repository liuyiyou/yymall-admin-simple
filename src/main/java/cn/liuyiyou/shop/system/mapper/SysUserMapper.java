package cn.liuyiyou.shop.system.mapper;

import cn.liuyiyou.shop.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据条件分页查询用户对象
     *
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    IPage<SysUser> selectUserList(Page page, @Param("item") SysUser sysUser);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    SysUser checkEmailUnique(String email);

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号码
     * @return 结果
     */
    SysUser checkPhoneUnique(String phonenumber);

    /**
     * 校验用户名称是否唯一
     *
     * @param loginName 登录名称
     * @return 结果
     */
    int checkLoginNameUnique(String loginName);

    SysUser selectUserInfoByUserId(Integer userId);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    SysUser selectUserByLoginName(String loginName);
}

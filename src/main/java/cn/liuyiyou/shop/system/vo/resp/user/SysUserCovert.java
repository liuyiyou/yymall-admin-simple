package cn.liuyiyou.shop.system.vo.resp.user;

import cn.liuyiyou.shop.system.entity.SysUser;
import org.springframework.beans.BeanUtils;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/1/7
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
public class SysUserCovert {


    public static SysUserListRespVo coverToSysUserListRespVo(SysUser sysUser) {
//        ModelMapper modelMapper = new ModelMapper();
//        SysUserListRespVo sysUserListRespVo = modelMapper.map(sysUser, SysUserListRespVo.class);
        SysUserListRespVo sysUserListRespVo = new SysUserListRespVo();
        BeanUtils.copyProperties(sysUser, sysUserListRespVo);
//        sysUserListRespVo.setAccountType(SysUserAccountType.INTERNAL.getCode().equals(sysUser.getAccountType()) ? "内部账号" : "外部账号");
        return sysUserListRespVo;

    }
}

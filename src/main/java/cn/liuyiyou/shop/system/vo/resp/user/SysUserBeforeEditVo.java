package cn.liuyiyou.shop.system.vo.resp.user;

import cn.liuyiyou.shop.system.vo.resp.role.SysRoleListRespVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/1/7
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
@ApiModel
public class SysUserBeforeEditVo {
    private SysUserListRespVo user;
    private List<SysRoleListRespVo> roles;
    private SysSupplierListRespVo supplier;
}

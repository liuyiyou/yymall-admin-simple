package cn.liuyiyou.shop.system.vo.req;

import lombok.Data;
import lombok.experimental.Accessors;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/1/15
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
public class LoginUserVo {
    private String username;
    private String password;
}

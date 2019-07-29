package cn.liuyiyou.shop.user.vo.resp;

import cn.liuyiyou.shop.user.entity.UserDelivery;
import lombok.Data;

import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/30
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
public class UserDeliveryListRespVo {

    private String chosenAddressId;
    private List<UserDelivery> list;

}

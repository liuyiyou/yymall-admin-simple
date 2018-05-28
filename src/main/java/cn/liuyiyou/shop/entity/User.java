package cn.liuyiyou.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author: liuyiyou
 * @date: 2018/5/28
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String accessToken;
    private String userId;
    private String realName;
    private String phoneNo;
    private String accountName;
    private String avatar;
    private String deptId;
    private String deptName;
}

package cn.liuyiyou.shop.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author: liuyiyou
 * @date: 2018/4/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqBody {

    public int page;
    public int pageSize;
}

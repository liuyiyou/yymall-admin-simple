package cn.liuyiyou.shop.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2019-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserDelivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * UID，user.id
     */
    private Integer uid;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 联系电话(手机号码)
     */
    private String tel;

    /**
     * 收货人身份证号码
     */
    private String idno;

    /**
     * 收货人所在区
     */
    private Integer countyCode;

    /**
     * 收货人所在省
     */
    private Integer provinceCode;

    /**
     * 收货人所在市
     */
    private Integer cityCode;

    /**
     * 是否是默认地址
     */
    private Boolean isDefault;

    /**
     * 收货人地址格式为{"addr":"奥体中心10区309室","city":"广州市","country":"天河区","prov":"广东省"}
     */
    private String addressDetail;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 收货人所在省
     */
    private String province;

    /**
     * 收货人所在市
     */
    private String city;

    /**
     * 收货人所在区
     */
    private String county;

    /**
     * 地址代码
     */
    private String areaCode;

    /**
     * 收货人地址(暂时不用)
     */
    private String address;


    public static final String ID = "id";

    public static final String UID = "uid";

    public static final String NAME = "name";

    public static final String TEL = "tel";

    public static final String IDNO = "idno";

    public static final String COUNTY_CODE = "county_code";

    public static final String PROVINCE_CODE = "province_code";

    public static final String CITY_CODE = "city_code";

    public static final String IS_DEFAULT = "is_default";

    public static final String ADDRESS_DETAIL = "address_detail";

    public static final String CREATE_TIME = "create_time";

    public static final String PROVINCE = "province";

    public static final String CITY = "city";

    public static final String COUNTY = "county";

    public static final String AREA_CODE = "area_code";

    public static final String ADDRESS = "address";

}

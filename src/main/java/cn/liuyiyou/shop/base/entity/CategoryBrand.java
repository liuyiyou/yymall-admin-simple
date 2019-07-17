package cn.liuyiyou.shop.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分类品牌表
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2019-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CategoryBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 外键，base_catalog.cata_id
     */
    @TableId(value = "cata_id", type = IdType.INPUT)
    private Integer cataId;

    /**
     * 外键，关联base_brand.brand_id
     */
    private Integer brandId;

    /**
     * 品牌权重
     */
    private Integer brandWeight;

    /**
     * 关联创建时间
     */
    private LocalDate createDate;

    /**
     * 关联最后修改时间
     */
    private LocalDate lastUpdate;


    public static final String CATA_ID = "cata_id";

    public static final String BRAND_ID = "brand_id";

    public static final String BRAND_WEIGHT = "brand_weight";

    public static final String CREATE_DATE = "create_date";

    public static final String LAST_UPDATE = "last_update";

}

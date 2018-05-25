package cn.liuyiyou.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prod {
    private Long prodId;

    private String prodName;

    private String keyWords;

    private Integer brandId;

    private String brandName;

    private String countryId;

    private Integer cataId;

    private String cataDesc;

    private String spuAttr;

    private Date createTime;

    private Byte status;

    private Date statusTime;

    private String album;

    private String brief;

    private Long createSuid;

    private String updateLogs;

    private Integer lastUpdate;

    private Byte popStatus;

    private String popAlbum;

    private String popDescribe;

    private String descp;

}
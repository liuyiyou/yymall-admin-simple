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
public class Banner {

    private Short bannerId;


    private Byte type;


    private String pic;


    private String redirectUrl;


    private Short weight;


    private Date createDate;


    private Date lastUpdate;


    private String filterChannels;


    private Integer applyCrowd;


    private Date startTime;


    private Date endTime;


    private String picV2;


    private Integer width;


    private Integer height;


}
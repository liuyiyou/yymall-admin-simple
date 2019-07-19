package cn.liuyiyou.shop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/19
 * @version: V1.0
 */
@Data
public class Subs implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object){
        return super.equals(object);
    }
}

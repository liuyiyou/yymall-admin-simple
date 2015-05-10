
package cn.liuyiyou.yishop.entity;

import java.util.List;

/**
 * 类目
 * @author liuyiyou
 *
 */
public class Category extends BaseEntity {

    private String nameEn;

    private String nameCn;

    private String nameUrl;

    private int    level;

    private int    parentId;

    private String status;

    private int    weight;
    
    //子类目
    private List<Category> subCategories;

    
    public String getNameEn() {
        return nameEn;
    }

   
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

   
    public String getNameCn() {
        return nameCn;
    }

    
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    
    public String getNameUrl() {
        return nameUrl;
    }

    
    public void setNameUrl(String nameUrl) {
        this.nameUrl = nameUrl;
    }

   
    public int getLevel() {
        return level;
    }

   
    public void setLevel(int level) {
        this.level = level;
    }

    
    public int getParentId() {
        return parentId;
    }

    
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

   
    public String getStatus() {
        return status;
    }

   
    public void setStatus(String status) {
        this.status = status;
    }

    
    public int getWeight() {
        return weight;
    }

   
    public void setWeight(int weight) {
        this.weight = weight;
    }


	public List<Category> getSubCategories() {
		return subCategories;
	}


	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
    
    

}

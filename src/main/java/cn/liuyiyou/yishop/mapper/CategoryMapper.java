package cn.liuyiyou.yishop.mapper;

import cn.liuyiyou.yishop.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 */
public interface CategoryMapper extends BaseMapper {

    public int queryNextIdByParentId(@Param("parentId") int parentId);

    public List<Category> queryByStatus(String status);

    public List<Category> queryByParentIdAndStatus(@Param("parentId") int parentId, @Param("status") String status);

    public List<Category> queryByLevelAndStatus(@Param("level") int level, @Param("status") String status);

    public Category queryByNameUrl(String nameUrl);

}

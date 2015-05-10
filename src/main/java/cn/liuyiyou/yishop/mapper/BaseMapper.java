package cn.liuyiyou.yishop.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 通用mapper，在idea下会报错，因为没有队形的xml文件。可以忽略该错误
 * @author liuyiyou
 */
public interface BaseMapper {

    /**
     * 新增记录
     * 
     * @param t
     */
    public <T> int insert(T t);

    /**
     * 根据ID查询记录
     * 
     * @param id
     * @return
     */
    public <T> T queryById(int id);

    public <T> List<T> queryAll();

    public <T> List<T> queryForPage(@Param("begin") int begin, @Param("end") int end);

    /**
     * 根据ID删除记录
     * 
     * @param id
     */
    public <T> void deleteById(int id);

    /**
     * 根据ID、用户ID删除记录
     * 
     * @param id
     */
    public <T> void deleteByIdAndUserId(@Param("id") int id, @Param("userId") int userId);

    /**
     * 更新记录
     * 
     * @param t
     */
    public <T> void update(T t);

    public int count();

}

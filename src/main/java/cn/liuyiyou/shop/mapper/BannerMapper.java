package cn.liuyiyou.shop.mapper;

import cn.liuyiyou.shop.entity.Banner;
import cn.liuyiyou.shop.entity.BannerExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_banner
     *
     * @mbg.generated
     */
    long countByExample(BannerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_banner
     *
     * @mbg.generated
     */
    int insert(Banner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_banner
     *
     * @mbg.generated
     */
    int insertSelective(Banner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_banner
     *
     * @mbg.generated
     */
    List<Banner> selectByExample(BannerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_banner
     *
     * @mbg.generated
     */
    Banner selectByPrimaryKey(Short bannerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_banner
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Banner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_banner
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Banner record);
}
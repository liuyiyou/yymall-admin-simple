package cn.liuyiyou.shop.mapper;

import cn.liuyiyou.shop.entity.Prod;
import cn.liuyiyou.shop.entity.ProdExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdMapper {
    @SelectProvider(type=ProdSqlProvider.class, method="countByExample")
    long countByExample(ProdExample example);

    @Insert({
        "insert into prod (prod_id, prod_name, ",
        "key_words, brand_id, ",
        "brand_name, country_id, ",
        "cata_id, cata_desc, ",
        "spu_attr, create_time, ",
        "status, status_time, ",
        "album, brief, create_suid, ",
        "update_logs, last_update, ",
        "pop_status, pop_album, ",
        "pop_describe, descp)",
        "values (#{prodId,jdbcType=BIGINT}, #{prodName,jdbcType=VARCHAR}, ",
        "#{keyWords,jdbcType=VARCHAR}, #{brandId,jdbcType=INTEGER}, ",
        "#{brandName,jdbcType=VARCHAR}, #{countryId,jdbcType=VARCHAR}, ",
        "#{cataId,jdbcType=INTEGER}, #{cataDesc,jdbcType=VARCHAR}, ",
        "#{spuAttr,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{statusTime,jdbcType=TIMESTAMP}, ",
        "#{album,jdbcType=VARCHAR}, #{brief,jdbcType=VARCHAR}, #{createSuid,jdbcType=BIGINT}, ",
        "#{updateLogs,jdbcType=VARCHAR}, #{lastUpdate,jdbcType=INTEGER}, ",
        "#{popStatus,jdbcType=TINYINT}, #{popAlbum,jdbcType=VARCHAR}, ",
        "#{popDescribe,jdbcType=VARCHAR}, #{descp,jdbcType=LONGVARCHAR})"
    })
    int insert(Prod record);

    @InsertProvider(type=ProdSqlProvider.class, method="insertSelective")
    int insertSelective(Prod record);

    @SelectProvider(type=ProdSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="prod_id", property="prodId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="prod_name", property="prodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="key_words", property="keyWords", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_id", property="brandId", jdbcType=JdbcType.INTEGER),
        @Result(column="brand_name", property="brandName", jdbcType=JdbcType.VARCHAR),
        @Result(column="country_id", property="countryId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cata_id", property="cataId", jdbcType=JdbcType.INTEGER),
        @Result(column="cata_desc", property="cataDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="spu_attr", property="spuAttr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="status_time", property="statusTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="album", property="album", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_suid", property="createSuid", jdbcType=JdbcType.BIGINT),
        @Result(column="update_logs", property="updateLogs", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.INTEGER),
        @Result(column="pop_status", property="popStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="pop_album", property="popAlbum", jdbcType=JdbcType.VARCHAR),
        @Result(column="pop_describe", property="popDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="descp", property="descp", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Prod> selectByExampleWithBLOBs(ProdExample example);

    @SelectProvider(type=ProdSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="prod_id", property="prodId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="prod_name", property="prodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="key_words", property="keyWords", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_id", property="brandId", jdbcType=JdbcType.INTEGER),
        @Result(column="brand_name", property="brandName", jdbcType=JdbcType.VARCHAR),
        @Result(column="country_id", property="countryId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cata_id", property="cataId", jdbcType=JdbcType.INTEGER),
        @Result(column="cata_desc", property="cataDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="spu_attr", property="spuAttr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="status_time", property="statusTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="album", property="album", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_suid", property="createSuid", jdbcType=JdbcType.BIGINT),
        @Result(column="update_logs", property="updateLogs", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.INTEGER),
        @Result(column="pop_status", property="popStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="pop_album", property="popAlbum", jdbcType=JdbcType.VARCHAR),
        @Result(column="pop_describe", property="popDescribe", jdbcType=JdbcType.VARCHAR)
    })
    List<Prod> selectByExample(ProdExample example);

    @Select({
        "select",
        "prod_id, prod_name, key_words, brand_id, brand_name, country_id, cata_id, cata_desc, ",
        "spu_attr, create_time, status, status_time, album, brief, create_suid, update_logs, ",
        "last_update, pop_status, pop_album, pop_describe, descp",
        "from prod",
        "where prod_id = #{prodId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="prod_id", property="prodId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="prod_name", property="prodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="key_words", property="keyWords", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_id", property="brandId", jdbcType=JdbcType.INTEGER),
        @Result(column="brand_name", property="brandName", jdbcType=JdbcType.VARCHAR),
        @Result(column="country_id", property="countryId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cata_id", property="cataId", jdbcType=JdbcType.INTEGER),
        @Result(column="cata_desc", property="cataDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="spu_attr", property="spuAttr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="status_time", property="statusTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="album", property="album", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_suid", property="createSuid", jdbcType=JdbcType.BIGINT),
        @Result(column="update_logs", property="updateLogs", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.INTEGER),
        @Result(column="pop_status", property="popStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="pop_album", property="popAlbum", jdbcType=JdbcType.VARCHAR),
        @Result(column="pop_describe", property="popDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="descp", property="descp", jdbcType=JdbcType.LONGVARCHAR)
    })
    Prod selectByPrimaryKey(Long prodId);

    @UpdateProvider(type=ProdSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Prod record);

    @Update({
        "update prod",
        "set prod_name = #{prodName,jdbcType=VARCHAR},",
          "key_words = #{keyWords,jdbcType=VARCHAR},",
          "brand_id = #{brandId,jdbcType=INTEGER},",
          "brand_name = #{brandName,jdbcType=VARCHAR},",
          "country_id = #{countryId,jdbcType=VARCHAR},",
          "cata_id = #{cataId,jdbcType=INTEGER},",
          "cata_desc = #{cataDesc,jdbcType=VARCHAR},",
          "spu_attr = #{spuAttr,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "status_time = #{statusTime,jdbcType=TIMESTAMP},",
          "album = #{album,jdbcType=VARCHAR},",
          "brief = #{brief,jdbcType=VARCHAR},",
          "create_suid = #{createSuid,jdbcType=BIGINT},",
          "update_logs = #{updateLogs,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=INTEGER},",
          "pop_status = #{popStatus,jdbcType=TINYINT},",
          "pop_album = #{popAlbum,jdbcType=VARCHAR},",
          "pop_describe = #{popDescribe,jdbcType=VARCHAR},",
          "descp = #{descp,jdbcType=LONGVARCHAR}",
        "where prod_id = #{prodId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Prod record);

    @Update({
        "update prod",
        "set prod_name = #{prodName,jdbcType=VARCHAR},",
          "key_words = #{keyWords,jdbcType=VARCHAR},",
          "brand_id = #{brandId,jdbcType=INTEGER},",
          "brand_name = #{brandName,jdbcType=VARCHAR},",
          "country_id = #{countryId,jdbcType=VARCHAR},",
          "cata_id = #{cataId,jdbcType=INTEGER},",
          "cata_desc = #{cataDesc,jdbcType=VARCHAR},",
          "spu_attr = #{spuAttr,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "status_time = #{statusTime,jdbcType=TIMESTAMP},",
          "album = #{album,jdbcType=VARCHAR},",
          "brief = #{brief,jdbcType=VARCHAR},",
          "create_suid = #{createSuid,jdbcType=BIGINT},",
          "update_logs = #{updateLogs,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=INTEGER},",
          "pop_status = #{popStatus,jdbcType=TINYINT},",
          "pop_album = #{popAlbum,jdbcType=VARCHAR},",
          "pop_describe = #{popDescribe,jdbcType=VARCHAR}",
        "where prod_id = #{prodId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Prod record);
}
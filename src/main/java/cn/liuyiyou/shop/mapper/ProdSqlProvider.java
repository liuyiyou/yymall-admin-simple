package cn.liuyiyou.shop.mapper;

import cn.liuyiyou.shop.entity.Prod;
import cn.liuyiyou.shop.entity.ProdExample.Criteria;
import cn.liuyiyou.shop.entity.ProdExample.Criterion;
import cn.liuyiyou.shop.entity.ProdExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class ProdSqlProvider {

    public String countByExample(ProdExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("prod");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Prod record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("prod");
        
        if (record.getProdId() != null) {
            sql.VALUES("prod_id", "#{prodId,jdbcType=BIGINT}");
        }
        
        if (record.getProdName() != null) {
            sql.VALUES("prod_name", "#{prodName,jdbcType=VARCHAR}");
        }
        
        if (record.getKeyWords() != null) {
            sql.VALUES("key_words", "#{keyWords,jdbcType=VARCHAR}");
        }
        
        if (record.getBrandId() != null) {
            sql.VALUES("brand_id", "#{brandId,jdbcType=INTEGER}");
        }
        
        if (record.getBrandName() != null) {
            sql.VALUES("brand_name", "#{brandName,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryId() != null) {
            sql.VALUES("country_id", "#{countryId,jdbcType=VARCHAR}");
        }
        
        if (record.getCataId() != null) {
            sql.VALUES("cata_id", "#{cataId,jdbcType=INTEGER}");
        }
        
        if (record.getCataDesc() != null) {
            sql.VALUES("cata_desc", "#{cataDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getSpuAttr() != null) {
            sql.VALUES("spu_attr", "#{spuAttr,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getStatusTime() != null) {
            sql.VALUES("status_time", "#{statusTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAlbum() != null) {
            sql.VALUES("album", "#{album,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            sql.VALUES("brief", "#{brief,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateSuid() != null) {
            sql.VALUES("create_suid", "#{createSuid,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateLogs() != null) {
            sql.VALUES("update_logs", "#{updateLogs,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=INTEGER}");
        }
        
        if (record.getPopStatus() != null) {
            sql.VALUES("pop_status", "#{popStatus,jdbcType=TINYINT}");
        }
        
        if (record.getPopAlbum() != null) {
            sql.VALUES("pop_album", "#{popAlbum,jdbcType=VARCHAR}");
        }
        
        if (record.getPopDescribe() != null) {
            sql.VALUES("pop_describe", "#{popDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getDescp() != null) {
            sql.VALUES("descp", "#{descp,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(ProdExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("prod_id");
        } else {
            sql.SELECT("prod_id");
        }
        sql.SELECT("prod_name");
        sql.SELECT("key_words");
        sql.SELECT("brand_id");
        sql.SELECT("brand_name");
        sql.SELECT("country_id");
        sql.SELECT("cata_id");
        sql.SELECT("cata_desc");
        sql.SELECT("spu_attr");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("status_time");
        sql.SELECT("album");
        sql.SELECT("brief");
        sql.SELECT("create_suid");
        sql.SELECT("update_logs");
        sql.SELECT("last_update");
        sql.SELECT("pop_status");
        sql.SELECT("pop_album");
        sql.SELECT("pop_describe");
        sql.SELECT("descp");
        sql.FROM("prod");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(ProdExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("prod_id");
        } else {
            sql.SELECT("prod_id");
        }
        sql.SELECT("prod_name");
        sql.SELECT("key_words");
        sql.SELECT("brand_id");
        sql.SELECT("brand_name");
        sql.SELECT("country_id");
        sql.SELECT("cata_id");
        sql.SELECT("cata_desc");
        sql.SELECT("spu_attr");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("status_time");
        sql.SELECT("album");
        sql.SELECT("brief");
        sql.SELECT("create_suid");
        sql.SELECT("update_logs");
        sql.SELECT("last_update");
        sql.SELECT("pop_status");
        sql.SELECT("pop_album");
        sql.SELECT("pop_describe");
        sql.FROM("prod");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Prod record) {
        SQL sql = new SQL();
        sql.UPDATE("prod");
        
        if (record.getProdName() != null) {
            sql.SET("prod_name = #{prodName,jdbcType=VARCHAR}");
        }
        
        if (record.getKeyWords() != null) {
            sql.SET("key_words = #{keyWords,jdbcType=VARCHAR}");
        }
        
        if (record.getBrandId() != null) {
            sql.SET("brand_id = #{brandId,jdbcType=INTEGER}");
        }
        
        if (record.getBrandName() != null) {
            sql.SET("brand_name = #{brandName,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryId() != null) {
            sql.SET("country_id = #{countryId,jdbcType=VARCHAR}");
        }
        
        if (record.getCataId() != null) {
            sql.SET("cata_id = #{cataId,jdbcType=INTEGER}");
        }
        
        if (record.getCataDesc() != null) {
            sql.SET("cata_desc = #{cataDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getSpuAttr() != null) {
            sql.SET("spu_attr = #{spuAttr,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getStatusTime() != null) {
            sql.SET("status_time = #{statusTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAlbum() != null) {
            sql.SET("album = #{album,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            sql.SET("brief = #{brief,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateSuid() != null) {
            sql.SET("create_suid = #{createSuid,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateLogs() != null) {
            sql.SET("update_logs = #{updateLogs,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=INTEGER}");
        }
        
        if (record.getPopStatus() != null) {
            sql.SET("pop_status = #{popStatus,jdbcType=TINYINT}");
        }
        
        if (record.getPopAlbum() != null) {
            sql.SET("pop_album = #{popAlbum,jdbcType=VARCHAR}");
        }
        
        if (record.getPopDescribe() != null) {
            sql.SET("pop_describe = #{popDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getDescp() != null) {
            sql.SET("descp = #{descp,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("prod_id = #{prodId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProdExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}
package cn.liuyiyou.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProdExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProdIdIsNull() {
            addCriterion("prod_id is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("prod_id is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(Long value) {
            addCriterion("prod_id =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(Long value) {
            addCriterion("prod_id <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(Long value) {
            addCriterion("prod_id >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(Long value) {
            addCriterion("prod_id >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(Long value) {
            addCriterion("prod_id <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(Long value) {
            addCriterion("prod_id <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<Long> values) {
            addCriterion("prod_id in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<Long> values) {
            addCriterion("prod_id not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(Long value1, Long value2) {
            addCriterion("prod_id between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(Long value1, Long value2) {
            addCriterion("prod_id not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdNameIsNull() {
            addCriterion("prod_name is null");
            return (Criteria) this;
        }

        public Criteria andProdNameIsNotNull() {
            addCriterion("prod_name is not null");
            return (Criteria) this;
        }

        public Criteria andProdNameEqualTo(String value) {
            addCriterion("prod_name =", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotEqualTo(String value) {
            addCriterion("prod_name <>", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameGreaterThan(String value) {
            addCriterion("prod_name >", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameGreaterThanOrEqualTo(String value) {
            addCriterion("prod_name >=", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLessThan(String value) {
            addCriterion("prod_name <", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLessThanOrEqualTo(String value) {
            addCriterion("prod_name <=", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLike(String value) {
            addCriterion("prod_name like", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotLike(String value) {
            addCriterion("prod_name not like", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameIn(List<String> values) {
            addCriterion("prod_name in", values, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotIn(List<String> values) {
            addCriterion("prod_name not in", values, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameBetween(String value1, String value2) {
            addCriterion("prod_name between", value1, value2, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotBetween(String value1, String value2) {
            addCriterion("prod_name not between", value1, value2, "prodName");
            return (Criteria) this;
        }

        public Criteria andKeyWordsIsNull() {
            addCriterion("key_words is null");
            return (Criteria) this;
        }

        public Criteria andKeyWordsIsNotNull() {
            addCriterion("key_words is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWordsEqualTo(String value) {
            addCriterion("key_words =", value, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsNotEqualTo(String value) {
            addCriterion("key_words <>", value, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsGreaterThan(String value) {
            addCriterion("key_words >", value, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsGreaterThanOrEqualTo(String value) {
            addCriterion("key_words >=", value, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsLessThan(String value) {
            addCriterion("key_words <", value, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsLessThanOrEqualTo(String value) {
            addCriterion("key_words <=", value, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsLike(String value) {
            addCriterion("key_words like", value, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsNotLike(String value) {
            addCriterion("key_words not like", value, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsIn(List<String> values) {
            addCriterion("key_words in", values, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsNotIn(List<String> values) {
            addCriterion("key_words not in", values, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsBetween(String value1, String value2) {
            addCriterion("key_words between", value1, value2, "keyWords");
            return (Criteria) this;
        }

        public Criteria andKeyWordsNotBetween(String value1, String value2) {
            addCriterion("key_words not between", value1, value2, "keyWords");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNull() {
            addCriterion("country_id is null");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNotNull() {
            addCriterion("country_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountryIdEqualTo(String value) {
            addCriterion("country_id =", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotEqualTo(String value) {
            addCriterion("country_id <>", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThan(String value) {
            addCriterion("country_id >", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThanOrEqualTo(String value) {
            addCriterion("country_id >=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThan(String value) {
            addCriterion("country_id <", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThanOrEqualTo(String value) {
            addCriterion("country_id <=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLike(String value) {
            addCriterion("country_id like", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotLike(String value) {
            addCriterion("country_id not like", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdIn(List<String> values) {
            addCriterion("country_id in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotIn(List<String> values) {
            addCriterion("country_id not in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdBetween(String value1, String value2) {
            addCriterion("country_id between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotBetween(String value1, String value2) {
            addCriterion("country_id not between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCataIdIsNull() {
            addCriterion("cata_id is null");
            return (Criteria) this;
        }

        public Criteria andCataIdIsNotNull() {
            addCriterion("cata_id is not null");
            return (Criteria) this;
        }

        public Criteria andCataIdEqualTo(Integer value) {
            addCriterion("cata_id =", value, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdNotEqualTo(Integer value) {
            addCriterion("cata_id <>", value, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdGreaterThan(Integer value) {
            addCriterion("cata_id >", value, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cata_id >=", value, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdLessThan(Integer value) {
            addCriterion("cata_id <", value, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdLessThanOrEqualTo(Integer value) {
            addCriterion("cata_id <=", value, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdIn(List<Integer> values) {
            addCriterion("cata_id in", values, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdNotIn(List<Integer> values) {
            addCriterion("cata_id not in", values, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdBetween(Integer value1, Integer value2) {
            addCriterion("cata_id between", value1, value2, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cata_id not between", value1, value2, "cataId");
            return (Criteria) this;
        }

        public Criteria andCataDescIsNull() {
            addCriterion("cata_desc is null");
            return (Criteria) this;
        }

        public Criteria andCataDescIsNotNull() {
            addCriterion("cata_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCataDescEqualTo(String value) {
            addCriterion("cata_desc =", value, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescNotEqualTo(String value) {
            addCriterion("cata_desc <>", value, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescGreaterThan(String value) {
            addCriterion("cata_desc >", value, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescGreaterThanOrEqualTo(String value) {
            addCriterion("cata_desc >=", value, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescLessThan(String value) {
            addCriterion("cata_desc <", value, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescLessThanOrEqualTo(String value) {
            addCriterion("cata_desc <=", value, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescLike(String value) {
            addCriterion("cata_desc like", value, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescNotLike(String value) {
            addCriterion("cata_desc not like", value, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescIn(List<String> values) {
            addCriterion("cata_desc in", values, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescNotIn(List<String> values) {
            addCriterion("cata_desc not in", values, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescBetween(String value1, String value2) {
            addCriterion("cata_desc between", value1, value2, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andCataDescNotBetween(String value1, String value2) {
            addCriterion("cata_desc not between", value1, value2, "cataDesc");
            return (Criteria) this;
        }

        public Criteria andSpuAttrIsNull() {
            addCriterion("spu_attr is null");
            return (Criteria) this;
        }

        public Criteria andSpuAttrIsNotNull() {
            addCriterion("spu_attr is not null");
            return (Criteria) this;
        }

        public Criteria andSpuAttrEqualTo(String value) {
            addCriterion("spu_attr =", value, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrNotEqualTo(String value) {
            addCriterion("spu_attr <>", value, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrGreaterThan(String value) {
            addCriterion("spu_attr >", value, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrGreaterThanOrEqualTo(String value) {
            addCriterion("spu_attr >=", value, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrLessThan(String value) {
            addCriterion("spu_attr <", value, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrLessThanOrEqualTo(String value) {
            addCriterion("spu_attr <=", value, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrLike(String value) {
            addCriterion("spu_attr like", value, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrNotLike(String value) {
            addCriterion("spu_attr not like", value, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrIn(List<String> values) {
            addCriterion("spu_attr in", values, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrNotIn(List<String> values) {
            addCriterion("spu_attr not in", values, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrBetween(String value1, String value2) {
            addCriterion("spu_attr between", value1, value2, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andSpuAttrNotBetween(String value1, String value2) {
            addCriterion("spu_attr not between", value1, value2, "spuAttr");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusTimeIsNull() {
            addCriterion("status_time is null");
            return (Criteria) this;
        }

        public Criteria andStatusTimeIsNotNull() {
            addCriterion("status_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatusTimeEqualTo(Date value) {
            addCriterion("status_time =", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeNotEqualTo(Date value) {
            addCriterion("status_time <>", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeGreaterThan(Date value) {
            addCriterion("status_time >", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("status_time >=", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeLessThan(Date value) {
            addCriterion("status_time <", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeLessThanOrEqualTo(Date value) {
            addCriterion("status_time <=", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeIn(List<Date> values) {
            addCriterion("status_time in", values, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeNotIn(List<Date> values) {
            addCriterion("status_time not in", values, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeBetween(Date value1, Date value2) {
            addCriterion("status_time between", value1, value2, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeNotBetween(Date value1, Date value2) {
            addCriterion("status_time not between", value1, value2, "statusTime");
            return (Criteria) this;
        }

        public Criteria andAlbumIsNull() {
            addCriterion("album is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIsNotNull() {
            addCriterion("album is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumEqualTo(String value) {
            addCriterion("album =", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotEqualTo(String value) {
            addCriterion("album <>", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumGreaterThan(String value) {
            addCriterion("album >", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumGreaterThanOrEqualTo(String value) {
            addCriterion("album >=", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLessThan(String value) {
            addCriterion("album <", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLessThanOrEqualTo(String value) {
            addCriterion("album <=", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLike(String value) {
            addCriterion("album like", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotLike(String value) {
            addCriterion("album not like", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumIn(List<String> values) {
            addCriterion("album in", values, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotIn(List<String> values) {
            addCriterion("album not in", values, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumBetween(String value1, String value2) {
            addCriterion("album between", value1, value2, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotBetween(String value1, String value2) {
            addCriterion("album not between", value1, value2, "album");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andCreateSuidIsNull() {
            addCriterion("create_suid is null");
            return (Criteria) this;
        }

        public Criteria andCreateSuidIsNotNull() {
            addCriterion("create_suid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSuidEqualTo(Long value) {
            addCriterion("create_suid =", value, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidNotEqualTo(Long value) {
            addCriterion("create_suid <>", value, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidGreaterThan(Long value) {
            addCriterion("create_suid >", value, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidGreaterThanOrEqualTo(Long value) {
            addCriterion("create_suid >=", value, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidLessThan(Long value) {
            addCriterion("create_suid <", value, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidLessThanOrEqualTo(Long value) {
            addCriterion("create_suid <=", value, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidIn(List<Long> values) {
            addCriterion("create_suid in", values, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidNotIn(List<Long> values) {
            addCriterion("create_suid not in", values, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidBetween(Long value1, Long value2) {
            addCriterion("create_suid between", value1, value2, "createSuid");
            return (Criteria) this;
        }

        public Criteria andCreateSuidNotBetween(Long value1, Long value2) {
            addCriterion("create_suid not between", value1, value2, "createSuid");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsIsNull() {
            addCriterion("update_logs is null");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsIsNotNull() {
            addCriterion("update_logs is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsEqualTo(String value) {
            addCriterion("update_logs =", value, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsNotEqualTo(String value) {
            addCriterion("update_logs <>", value, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsGreaterThan(String value) {
            addCriterion("update_logs >", value, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsGreaterThanOrEqualTo(String value) {
            addCriterion("update_logs >=", value, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsLessThan(String value) {
            addCriterion("update_logs <", value, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsLessThanOrEqualTo(String value) {
            addCriterion("update_logs <=", value, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsLike(String value) {
            addCriterion("update_logs like", value, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsNotLike(String value) {
            addCriterion("update_logs not like", value, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsIn(List<String> values) {
            addCriterion("update_logs in", values, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsNotIn(List<String> values) {
            addCriterion("update_logs not in", values, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsBetween(String value1, String value2) {
            addCriterion("update_logs between", value1, value2, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andUpdateLogsNotBetween(String value1, String value2) {
            addCriterion("update_logs not between", value1, value2, "updateLogs");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNull() {
            addCriterion("last_update is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNotNull() {
            addCriterion("last_update is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateEqualTo(Integer value) {
            addCriterion("last_update =", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotEqualTo(Integer value) {
            addCriterion("last_update <>", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThan(Integer value) {
            addCriterion("last_update >", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_update >=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThan(Integer value) {
            addCriterion("last_update <", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("last_update <=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIn(List<Integer> values) {
            addCriterion("last_update in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotIn(List<Integer> values) {
            addCriterion("last_update not in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateBetween(Integer value1, Integer value2) {
            addCriterion("last_update between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("last_update not between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andPopStatusIsNull() {
            addCriterion("pop_status is null");
            return (Criteria) this;
        }

        public Criteria andPopStatusIsNotNull() {
            addCriterion("pop_status is not null");
            return (Criteria) this;
        }

        public Criteria andPopStatusEqualTo(Byte value) {
            addCriterion("pop_status =", value, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusNotEqualTo(Byte value) {
            addCriterion("pop_status <>", value, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusGreaterThan(Byte value) {
            addCriterion("pop_status >", value, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("pop_status >=", value, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusLessThan(Byte value) {
            addCriterion("pop_status <", value, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusLessThanOrEqualTo(Byte value) {
            addCriterion("pop_status <=", value, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusIn(List<Byte> values) {
            addCriterion("pop_status in", values, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusNotIn(List<Byte> values) {
            addCriterion("pop_status not in", values, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusBetween(Byte value1, Byte value2) {
            addCriterion("pop_status between", value1, value2, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("pop_status not between", value1, value2, "popStatus");
            return (Criteria) this;
        }

        public Criteria andPopAlbumIsNull() {
            addCriterion("pop_album is null");
            return (Criteria) this;
        }

        public Criteria andPopAlbumIsNotNull() {
            addCriterion("pop_album is not null");
            return (Criteria) this;
        }

        public Criteria andPopAlbumEqualTo(String value) {
            addCriterion("pop_album =", value, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumNotEqualTo(String value) {
            addCriterion("pop_album <>", value, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumGreaterThan(String value) {
            addCriterion("pop_album >", value, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumGreaterThanOrEqualTo(String value) {
            addCriterion("pop_album >=", value, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumLessThan(String value) {
            addCriterion("pop_album <", value, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumLessThanOrEqualTo(String value) {
            addCriterion("pop_album <=", value, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumLike(String value) {
            addCriterion("pop_album like", value, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumNotLike(String value) {
            addCriterion("pop_album not like", value, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumIn(List<String> values) {
            addCriterion("pop_album in", values, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumNotIn(List<String> values) {
            addCriterion("pop_album not in", values, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumBetween(String value1, String value2) {
            addCriterion("pop_album between", value1, value2, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopAlbumNotBetween(String value1, String value2) {
            addCriterion("pop_album not between", value1, value2, "popAlbum");
            return (Criteria) this;
        }

        public Criteria andPopDescribeIsNull() {
            addCriterion("pop_describe is null");
            return (Criteria) this;
        }

        public Criteria andPopDescribeIsNotNull() {
            addCriterion("pop_describe is not null");
            return (Criteria) this;
        }

        public Criteria andPopDescribeEqualTo(String value) {
            addCriterion("pop_describe =", value, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeNotEqualTo(String value) {
            addCriterion("pop_describe <>", value, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeGreaterThan(String value) {
            addCriterion("pop_describe >", value, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("pop_describe >=", value, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeLessThan(String value) {
            addCriterion("pop_describe <", value, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeLessThanOrEqualTo(String value) {
            addCriterion("pop_describe <=", value, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeLike(String value) {
            addCriterion("pop_describe like", value, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeNotLike(String value) {
            addCriterion("pop_describe not like", value, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeIn(List<String> values) {
            addCriterion("pop_describe in", values, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeNotIn(List<String> values) {
            addCriterion("pop_describe not in", values, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeBetween(String value1, String value2) {
            addCriterion("pop_describe between", value1, value2, "popDescribe");
            return (Criteria) this;
        }

        public Criteria andPopDescribeNotBetween(String value1, String value2) {
            addCriterion("pop_describe not between", value1, value2, "popDescribe");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
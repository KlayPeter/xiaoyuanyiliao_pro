package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class XyyiliaoyaopingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XyyiliaoyaopingExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDrugnameIsNull() {
            addCriterion("drugname is null");
            return (Criteria) this;
        }

        public Criteria andDrugnameIsNotNull() {
            addCriterion("drugname is not null");
            return (Criteria) this;
        }

        public Criteria andDrugnameEqualTo(String value) {
            addCriterion("drugname =", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameNotEqualTo(String value) {
            addCriterion("drugname <>", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameGreaterThan(String value) {
            addCriterion("drugname >", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameGreaterThanOrEqualTo(String value) {
            addCriterion("drugname >=", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameLessThan(String value) {
            addCriterion("drugname <", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameLessThanOrEqualTo(String value) {
            addCriterion("drugname <=", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameLike(String value) {
            addCriterion("drugname like", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameNotLike(String value) {
            addCriterion("drugname not like", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameIn(List<String> values) {
            addCriterion("drugname in", values, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameNotIn(List<String> values) {
            addCriterion("drugname not in", values, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameBetween(String value1, String value2) {
            addCriterion("drugname between", value1, value2, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameNotBetween(String value1, String value2) {
            addCriterion("drugname not between", value1, value2, "drugname");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaIsNull() {
            addCriterion("shengchanchangjia is null");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaIsNotNull() {
            addCriterion("shengchanchangjia is not null");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaEqualTo(String value) {
            addCriterion("shengchanchangjia =", value, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaNotEqualTo(String value) {
            addCriterion("shengchanchangjia <>", value, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaGreaterThan(String value) {
            addCriterion("shengchanchangjia >", value, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaGreaterThanOrEqualTo(String value) {
            addCriterion("shengchanchangjia >=", value, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaLessThan(String value) {
            addCriterion("shengchanchangjia <", value, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaLessThanOrEqualTo(String value) {
            addCriterion("shengchanchangjia <=", value, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaLike(String value) {
            addCriterion("shengchanchangjia like", value, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaNotLike(String value) {
            addCriterion("shengchanchangjia not like", value, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaIn(List<String> values) {
            addCriterion("shengchanchangjia in", values, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaNotIn(List<String> values) {
            addCriterion("shengchanchangjia not in", values, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaBetween(String value1, String value2) {
            addCriterion("shengchanchangjia between", value1, value2, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andShengchanchangjiaNotBetween(String value1, String value2) {
            addCriterion("shengchanchangjia not between", value1, value2, "shengchanchangjia");
            return (Criteria) this;
        }

        public Criteria andDanweiIsNull() {
            addCriterion("danwei is null");
            return (Criteria) this;
        }

        public Criteria andDanweiIsNotNull() {
            addCriterion("danwei is not null");
            return (Criteria) this;
        }

        public Criteria andDanweiEqualTo(String value) {
            addCriterion("danwei =", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotEqualTo(String value) {
            addCriterion("danwei <>", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiGreaterThan(String value) {
            addCriterion("danwei >", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiGreaterThanOrEqualTo(String value) {
            addCriterion("danwei >=", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLessThan(String value) {
            addCriterion("danwei <", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLessThanOrEqualTo(String value) {
            addCriterion("danwei <=", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLike(String value) {
            addCriterion("danwei like", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotLike(String value) {
            addCriterion("danwei not like", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiIn(List<String> values) {
            addCriterion("danwei in", values, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotIn(List<String> values) {
            addCriterion("danwei not in", values, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiBetween(String value1, String value2) {
            addCriterion("danwei between", value1, value2, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotBetween(String value1, String value2) {
            addCriterion("danwei not between", value1, value2, "danwei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiIsNull() {
            addCriterion("yaopingfenlei is null");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiIsNotNull() {
            addCriterion("yaopingfenlei is not null");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiEqualTo(String value) {
            addCriterion("yaopingfenlei =", value, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiNotEqualTo(String value) {
            addCriterion("yaopingfenlei <>", value, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiGreaterThan(String value) {
            addCriterion("yaopingfenlei >", value, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiGreaterThanOrEqualTo(String value) {
            addCriterion("yaopingfenlei >=", value, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiLessThan(String value) {
            addCriterion("yaopingfenlei <", value, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiLessThanOrEqualTo(String value) {
            addCriterion("yaopingfenlei <=", value, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiLike(String value) {
            addCriterion("yaopingfenlei like", value, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiNotLike(String value) {
            addCriterion("yaopingfenlei not like", value, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiIn(List<String> values) {
            addCriterion("yaopingfenlei in", values, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiNotIn(List<String> values) {
            addCriterion("yaopingfenlei not in", values, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiBetween(String value1, String value2) {
            addCriterion("yaopingfenlei between", value1, value2, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andYaopingfenleiNotBetween(String value1, String value2) {
            addCriterion("yaopingfenlei not between", value1, value2, "yaopingfenlei");
            return (Criteria) this;
        }

        public Criteria andKucunIsNull() {
            addCriterion("kucun is null");
            return (Criteria) this;
        }

        public Criteria andKucunIsNotNull() {
            addCriterion("kucun is not null");
            return (Criteria) this;
        }

        public Criteria andKucunEqualTo(String value) {
            addCriterion("kucun =", value, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunNotEqualTo(String value) {
            addCriterion("kucun <>", value, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunGreaterThan(String value) {
            addCriterion("kucun >", value, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunGreaterThanOrEqualTo(String value) {
            addCriterion("kucun >=", value, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunLessThan(String value) {
            addCriterion("kucun <", value, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunLessThanOrEqualTo(String value) {
            addCriterion("kucun <=", value, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunLike(String value) {
            addCriterion("kucun like", value, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunNotLike(String value) {
            addCriterion("kucun not like", value, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunIn(List<String> values) {
            addCriterion("kucun in", values, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunNotIn(List<String> values) {
            addCriterion("kucun not in", values, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunBetween(String value1, String value2) {
            addCriterion("kucun between", value1, value2, "kucun");
            return (Criteria) this;
        }

        public Criteria andKucunNotBetween(String value1, String value2) {
            addCriterion("kucun not between", value1, value2, "kucun");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTixingkucunIsNull() {
            addCriterion("tixingkucun is null");
            return (Criteria) this;
        }

        public Criteria andTixingkucunIsNotNull() {
            addCriterion("tixingkucun is not null");
            return (Criteria) this;
        }

        public Criteria andTixingkucunEqualTo(String value) {
            addCriterion("tixingkucun =", value, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunNotEqualTo(String value) {
            addCriterion("tixingkucun <>", value, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunGreaterThan(String value) {
            addCriterion("tixingkucun >", value, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunGreaterThanOrEqualTo(String value) {
            addCriterion("tixingkucun >=", value, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunLessThan(String value) {
            addCriterion("tixingkucun <", value, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunLessThanOrEqualTo(String value) {
            addCriterion("tixingkucun <=", value, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunLike(String value) {
            addCriterion("tixingkucun like", value, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunNotLike(String value) {
            addCriterion("tixingkucun not like", value, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunIn(List<String> values) {
            addCriterion("tixingkucun in", values, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunNotIn(List<String> values) {
            addCriterion("tixingkucun not in", values, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunBetween(String value1, String value2) {
            addCriterion("tixingkucun between", value1, value2, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andTixingkucunNotBetween(String value1, String value2) {
            addCriterion("tixingkucun not between", value1, value2, "tixingkucun");
            return (Criteria) this;
        }

        public Criteria andShuomingIsNull() {
            addCriterion("shuoming is null");
            return (Criteria) this;
        }

        public Criteria andShuomingIsNotNull() {
            addCriterion("shuoming is not null");
            return (Criteria) this;
        }

        public Criteria andShuomingEqualTo(String value) {
            addCriterion("shuoming =", value, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingNotEqualTo(String value) {
            addCriterion("shuoming <>", value, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingGreaterThan(String value) {
            addCriterion("shuoming >", value, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingGreaterThanOrEqualTo(String value) {
            addCriterion("shuoming >=", value, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingLessThan(String value) {
            addCriterion("shuoming <", value, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingLessThanOrEqualTo(String value) {
            addCriterion("shuoming <=", value, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingLike(String value) {
            addCriterion("shuoming like", value, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingNotLike(String value) {
            addCriterion("shuoming not like", value, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingIn(List<String> values) {
            addCriterion("shuoming in", values, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingNotIn(List<String> values) {
            addCriterion("shuoming not in", values, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingBetween(String value1, String value2) {
            addCriterion("shuoming between", value1, value2, "shuoming");
            return (Criteria) this;
        }

        public Criteria andShuomingNotBetween(String value1, String value2) {
            addCriterion("shuoming not between", value1, value2, "shuoming");
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
package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class TijianyhyuyueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TijianyhyuyueExample() {
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

        public Criteria andXytijianshixiangIsNull() {
            addCriterion("xytijianshixiang is null");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangIsNotNull() {
            addCriterion("xytijianshixiang is not null");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangEqualTo(String value) {
            addCriterion("xytijianshixiang =", value, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangNotEqualTo(String value) {
            addCriterion("xytijianshixiang <>", value, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangGreaterThan(String value) {
            addCriterion("xytijianshixiang >", value, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangGreaterThanOrEqualTo(String value) {
            addCriterion("xytijianshixiang >=", value, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangLessThan(String value) {
            addCriterion("xytijianshixiang <", value, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangLessThanOrEqualTo(String value) {
            addCriterion("xytijianshixiang <=", value, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangLike(String value) {
            addCriterion("xytijianshixiang like", value, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangNotLike(String value) {
            addCriterion("xytijianshixiang not like", value, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangIn(List<String> values) {
            addCriterion("xytijianshixiang in", values, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangNotIn(List<String> values) {
            addCriterion("xytijianshixiang not in", values, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangBetween(String value1, String value2) {
            addCriterion("xytijianshixiang between", value1, value2, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangNotBetween(String value1, String value2) {
            addCriterion("xytijianshixiang not between", value1, value2, "xytijianshixiang");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidIsNull() {
            addCriterion("xytijianshixiangid is null");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidIsNotNull() {
            addCriterion("xytijianshixiangid is not null");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidEqualTo(Integer value) {
            addCriterion("xytijianshixiangid =", value, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidNotEqualTo(Integer value) {
            addCriterion("xytijianshixiangid <>", value, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidGreaterThan(Integer value) {
            addCriterion("xytijianshixiangid >", value, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidGreaterThanOrEqualTo(Integer value) {
            addCriterion("xytijianshixiangid >=", value, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidLessThan(Integer value) {
            addCriterion("xytijianshixiangid <", value, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidLessThanOrEqualTo(Integer value) {
            addCriterion("xytijianshixiangid <=", value, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidIn(List<Integer> values) {
            addCriterion("xytijianshixiangid in", values, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidNotIn(List<Integer> values) {
            addCriterion("xytijianshixiangid not in", values, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidBetween(Integer value1, Integer value2) {
            addCriterion("xytijianshixiangid between", value1, value2, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXytijianshixiangidNotBetween(Integer value1, Integer value2) {
            addCriterion("xytijianshixiangid not between", value1, value2, "xytijianshixiangid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhIsNull() {
            addCriterion("xyyiliaoyh is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhIsNotNull() {
            addCriterion("xyyiliaoyh is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhEqualTo(String value) {
            addCriterion("xyyiliaoyh =", value, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhNotEqualTo(String value) {
            addCriterion("xyyiliaoyh <>", value, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhGreaterThan(String value) {
            addCriterion("xyyiliaoyh >", value, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhGreaterThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyh >=", value, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhLessThan(String value) {
            addCriterion("xyyiliaoyh <", value, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhLessThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyh <=", value, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhLike(String value) {
            addCriterion("xyyiliaoyh like", value, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhNotLike(String value) {
            addCriterion("xyyiliaoyh not like", value, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhIn(List<String> values) {
            addCriterion("xyyiliaoyh in", values, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhNotIn(List<String> values) {
            addCriterion("xyyiliaoyh not in", values, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhBetween(String value1, String value2) {
            addCriterion("xyyiliaoyh between", value1, value2, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhNotBetween(String value1, String value2) {
            addCriterion("xyyiliaoyh not between", value1, value2, "xyyiliaoyh");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidIsNull() {
            addCriterion("xyyiliaoyhid is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidIsNotNull() {
            addCriterion("xyyiliaoyhid is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidEqualTo(Integer value) {
            addCriterion("xyyiliaoyhid =", value, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidNotEqualTo(Integer value) {
            addCriterion("xyyiliaoyhid <>", value, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidGreaterThan(Integer value) {
            addCriterion("xyyiliaoyhid >", value, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidGreaterThanOrEqualTo(Integer value) {
            addCriterion("xyyiliaoyhid >=", value, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidLessThan(Integer value) {
            addCriterion("xyyiliaoyhid <", value, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidLessThanOrEqualTo(Integer value) {
            addCriterion("xyyiliaoyhid <=", value, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidIn(List<Integer> values) {
            addCriterion("xyyiliaoyhid in", values, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidNotIn(List<Integer> values) {
            addCriterion("xyyiliaoyhid not in", values, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidBetween(Integer value1, Integer value2) {
            addCriterion("xyyiliaoyhid between", value1, value2, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhidNotBetween(Integer value1, Integer value2) {
            addCriterion("xyyiliaoyhid not between", value1, value2, "xyyiliaoyhid");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andShijianIsNull() {
            addCriterion("shijian is null");
            return (Criteria) this;
        }

        public Criteria andShijianIsNotNull() {
            addCriterion("shijian is not null");
            return (Criteria) this;
        }

        public Criteria andShijianEqualTo(String value) {
            addCriterion("shijian =", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotEqualTo(String value) {
            addCriterion("shijian <>", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianGreaterThan(String value) {
            addCriterion("shijian >", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianGreaterThanOrEqualTo(String value) {
            addCriterion("shijian >=", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLessThan(String value) {
            addCriterion("shijian <", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLessThanOrEqualTo(String value) {
            addCriterion("shijian <=", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLike(String value) {
            addCriterion("shijian like", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotLike(String value) {
            addCriterion("shijian not like", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianIn(List<String> values) {
            addCriterion("shijian in", values, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotIn(List<String> values) {
            addCriterion("shijian not in", values, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianBetween(String value1, String value2) {
            addCriterion("shijian between", value1, value2, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotBetween(String value1, String value2) {
            addCriterion("shijian not between", value1, value2, "shijian");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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
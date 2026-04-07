package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class YuyueduihuaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YuyueduihuaExample() {
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

        public Criteria andXyyiliaopaibanyuyueIsNull() {
            addCriterion("xyyiliaopaibanyuyue is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueIsNotNull() {
            addCriterion("xyyiliaopaibanyuyue is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueEqualTo(String value) {
            addCriterion("xyyiliaopaibanyuyue =", value, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueNotEqualTo(String value) {
            addCriterion("xyyiliaopaibanyuyue <>", value, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueGreaterThan(String value) {
            addCriterion("xyyiliaopaibanyuyue >", value, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueGreaterThanOrEqualTo(String value) {
            addCriterion("xyyiliaopaibanyuyue >=", value, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueLessThan(String value) {
            addCriterion("xyyiliaopaibanyuyue <", value, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueLessThanOrEqualTo(String value) {
            addCriterion("xyyiliaopaibanyuyue <=", value, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueLike(String value) {
            addCriterion("xyyiliaopaibanyuyue like", value, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueNotLike(String value) {
            addCriterion("xyyiliaopaibanyuyue not like", value, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueIn(List<String> values) {
            addCriterion("xyyiliaopaibanyuyue in", values, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueNotIn(List<String> values) {
            addCriterion("xyyiliaopaibanyuyue not in", values, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueBetween(String value1, String value2) {
            addCriterion("xyyiliaopaibanyuyue between", value1, value2, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueNotBetween(String value1, String value2) {
            addCriterion("xyyiliaopaibanyuyue not between", value1, value2, "xyyiliaopaibanyuyue");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidIsNull() {
            addCriterion("xyyiliaopaibanyuyueid is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidIsNotNull() {
            addCriterion("xyyiliaopaibanyuyueid is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidEqualTo(Integer value) {
            addCriterion("xyyiliaopaibanyuyueid =", value, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidNotEqualTo(Integer value) {
            addCriterion("xyyiliaopaibanyuyueid <>", value, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidGreaterThan(Integer value) {
            addCriterion("xyyiliaopaibanyuyueid >", value, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidGreaterThanOrEqualTo(Integer value) {
            addCriterion("xyyiliaopaibanyuyueid >=", value, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidLessThan(Integer value) {
            addCriterion("xyyiliaopaibanyuyueid <", value, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidLessThanOrEqualTo(Integer value) {
            addCriterion("xyyiliaopaibanyuyueid <=", value, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidIn(List<Integer> values) {
            addCriterion("xyyiliaopaibanyuyueid in", values, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidNotIn(List<Integer> values) {
            addCriterion("xyyiliaopaibanyuyueid not in", values, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidBetween(Integer value1, Integer value2) {
            addCriterion("xyyiliaopaibanyuyueid between", value1, value2, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andXyyiliaopaibanyuyueidNotBetween(Integer value1, Integer value2) {
            addCriterion("xyyiliaopaibanyuyueid not between", value1, value2, "xyyiliaopaibanyuyueid");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andDuihuauserIsNull() {
            addCriterion("duihuauser is null");
            return (Criteria) this;
        }

        public Criteria andDuihuauserIsNotNull() {
            addCriterion("duihuauser is not null");
            return (Criteria) this;
        }

        public Criteria andDuihuauserEqualTo(String value) {
            addCriterion("duihuauser =", value, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserNotEqualTo(String value) {
            addCriterion("duihuauser <>", value, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserGreaterThan(String value) {
            addCriterion("duihuauser >", value, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserGreaterThanOrEqualTo(String value) {
            addCriterion("duihuauser >=", value, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserLessThan(String value) {
            addCriterion("duihuauser <", value, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserLessThanOrEqualTo(String value) {
            addCriterion("duihuauser <=", value, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserLike(String value) {
            addCriterion("duihuauser like", value, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserNotLike(String value) {
            addCriterion("duihuauser not like", value, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserIn(List<String> values) {
            addCriterion("duihuauser in", values, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserNotIn(List<String> values) {
            addCriterion("duihuauser not in", values, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserBetween(String value1, String value2) {
            addCriterion("duihuauser between", value1, value2, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauserNotBetween(String value1, String value2) {
            addCriterion("duihuauser not between", value1, value2, "duihuauser");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridIsNull() {
            addCriterion("duihuauserid is null");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridIsNotNull() {
            addCriterion("duihuauserid is not null");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridEqualTo(Integer value) {
            addCriterion("duihuauserid =", value, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridNotEqualTo(Integer value) {
            addCriterion("duihuauserid <>", value, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridGreaterThan(Integer value) {
            addCriterion("duihuauserid >", value, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("duihuauserid >=", value, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridLessThan(Integer value) {
            addCriterion("duihuauserid <", value, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridLessThanOrEqualTo(Integer value) {
            addCriterion("duihuauserid <=", value, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridIn(List<Integer> values) {
            addCriterion("duihuauserid in", values, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridNotIn(List<Integer> values) {
            addCriterion("duihuauserid not in", values, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridBetween(Integer value1, Integer value2) {
            addCriterion("duihuauserid between", value1, value2, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauseridNotBetween(Integer value1, Integer value2) {
            addCriterion("duihuauserid not between", value1, value2, "duihuauserid");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleIsNull() {
            addCriterion("duihuauserrole is null");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleIsNotNull() {
            addCriterion("duihuauserrole is not null");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleEqualTo(String value) {
            addCriterion("duihuauserrole =", value, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleNotEqualTo(String value) {
            addCriterion("duihuauserrole <>", value, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleGreaterThan(String value) {
            addCriterion("duihuauserrole >", value, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleGreaterThanOrEqualTo(String value) {
            addCriterion("duihuauserrole >=", value, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleLessThan(String value) {
            addCriterion("duihuauserrole <", value, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleLessThanOrEqualTo(String value) {
            addCriterion("duihuauserrole <=", value, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleLike(String value) {
            addCriterion("duihuauserrole like", value, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleNotLike(String value) {
            addCriterion("duihuauserrole not like", value, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleIn(List<String> values) {
            addCriterion("duihuauserrole in", values, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleNotIn(List<String> values) {
            addCriterion("duihuauserrole not in", values, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleBetween(String value1, String value2) {
            addCriterion("duihuauserrole between", value1, value2, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserroleNotBetween(String value1, String value2) {
            addCriterion("duihuauserrole not between", value1, value2, "duihuauserrole");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgIsNull() {
            addCriterion("duihuauserimg is null");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgIsNotNull() {
            addCriterion("duihuauserimg is not null");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgEqualTo(String value) {
            addCriterion("duihuauserimg =", value, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgNotEqualTo(String value) {
            addCriterion("duihuauserimg <>", value, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgGreaterThan(String value) {
            addCriterion("duihuauserimg >", value, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgGreaterThanOrEqualTo(String value) {
            addCriterion("duihuauserimg >=", value, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgLessThan(String value) {
            addCriterion("duihuauserimg <", value, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgLessThanOrEqualTo(String value) {
            addCriterion("duihuauserimg <=", value, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgLike(String value) {
            addCriterion("duihuauserimg like", value, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgNotLike(String value) {
            addCriterion("duihuauserimg not like", value, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgIn(List<String> values) {
            addCriterion("duihuauserimg in", values, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgNotIn(List<String> values) {
            addCriterion("duihuauserimg not in", values, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgBetween(String value1, String value2) {
            addCriterion("duihuauserimg between", value1, value2, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauserimgNotBetween(String value1, String value2) {
            addCriterion("duihuauserimg not between", value1, value2, "duihuauserimg");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeIsNull() {
            addCriterion("duihuauseraddtime is null");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeIsNotNull() {
            addCriterion("duihuauseraddtime is not null");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeEqualTo(String value) {
            addCriterion("duihuauseraddtime =", value, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeNotEqualTo(String value) {
            addCriterion("duihuauseraddtime <>", value, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeGreaterThan(String value) {
            addCriterion("duihuauseraddtime >", value, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("duihuauseraddtime >=", value, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeLessThan(String value) {
            addCriterion("duihuauseraddtime <", value, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeLessThanOrEqualTo(String value) {
            addCriterion("duihuauseraddtime <=", value, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeLike(String value) {
            addCriterion("duihuauseraddtime like", value, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeNotLike(String value) {
            addCriterion("duihuauseraddtime not like", value, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeIn(List<String> values) {
            addCriterion("duihuauseraddtime in", values, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeNotIn(List<String> values) {
            addCriterion("duihuauseraddtime not in", values, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeBetween(String value1, String value2) {
            addCriterion("duihuauseraddtime between", value1, value2, "duihuauseraddtime");
            return (Criteria) this;
        }

        public Criteria andDuihuauseraddtimeNotBetween(String value1, String value2) {
            addCriterion("duihuauseraddtime not between", value1, value2, "duihuauseraddtime");
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
package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class XyggaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XyggaoExample() {
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

        public Criteria andXytitleIsNull() {
            addCriterion("xytitle is null");
            return (Criteria) this;
        }

        public Criteria andXytitleIsNotNull() {
            addCriterion("xytitle is not null");
            return (Criteria) this;
        }

        public Criteria andXytitleEqualTo(String value) {
            addCriterion("xytitle =", value, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleNotEqualTo(String value) {
            addCriterion("xytitle <>", value, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleGreaterThan(String value) {
            addCriterion("xytitle >", value, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleGreaterThanOrEqualTo(String value) {
            addCriterion("xytitle >=", value, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleLessThan(String value) {
            addCriterion("xytitle <", value, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleLessThanOrEqualTo(String value) {
            addCriterion("xytitle <=", value, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleLike(String value) {
            addCriterion("xytitle like", value, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleNotLike(String value) {
            addCriterion("xytitle not like", value, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleIn(List<String> values) {
            addCriterion("xytitle in", values, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleNotIn(List<String> values) {
            addCriterion("xytitle not in", values, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleBetween(String value1, String value2) {
            addCriterion("xytitle between", value1, value2, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXytitleNotBetween(String value1, String value2) {
            addCriterion("xytitle not between", value1, value2, "xytitle");
            return (Criteria) this;
        }

        public Criteria andXycontentIsNull() {
            addCriterion("xycontent is null");
            return (Criteria) this;
        }

        public Criteria andXycontentIsNotNull() {
            addCriterion("xycontent is not null");
            return (Criteria) this;
        }

        public Criteria andXycontentEqualTo(String value) {
            addCriterion("xycontent =", value, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentNotEqualTo(String value) {
            addCriterion("xycontent <>", value, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentGreaterThan(String value) {
            addCriterion("xycontent >", value, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentGreaterThanOrEqualTo(String value) {
            addCriterion("xycontent >=", value, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentLessThan(String value) {
            addCriterion("xycontent <", value, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentLessThanOrEqualTo(String value) {
            addCriterion("xycontent <=", value, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentLike(String value) {
            addCriterion("xycontent like", value, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentNotLike(String value) {
            addCriterion("xycontent not like", value, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentIn(List<String> values) {
            addCriterion("xycontent in", values, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentNotIn(List<String> values) {
            addCriterion("xycontent not in", values, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentBetween(String value1, String value2) {
            addCriterion("xycontent between", value1, value2, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXycontentNotBetween(String value1, String value2) {
            addCriterion("xycontent not between", value1, value2, "xycontent");
            return (Criteria) this;
        }

        public Criteria andXyimgIsNull() {
            addCriterion("xyimg is null");
            return (Criteria) this;
        }

        public Criteria andXyimgIsNotNull() {
            addCriterion("xyimg is not null");
            return (Criteria) this;
        }

        public Criteria andXyimgEqualTo(String value) {
            addCriterion("xyimg =", value, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgNotEqualTo(String value) {
            addCriterion("xyimg <>", value, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgGreaterThan(String value) {
            addCriterion("xyimg >", value, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgGreaterThanOrEqualTo(String value) {
            addCriterion("xyimg >=", value, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgLessThan(String value) {
            addCriterion("xyimg <", value, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgLessThanOrEqualTo(String value) {
            addCriterion("xyimg <=", value, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgLike(String value) {
            addCriterion("xyimg like", value, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgNotLike(String value) {
            addCriterion("xyimg not like", value, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgIn(List<String> values) {
            addCriterion("xyimg in", values, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgNotIn(List<String> values) {
            addCriterion("xyimg not in", values, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgBetween(String value1, String value2) {
            addCriterion("xyimg between", value1, value2, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyimgNotBetween(String value1, String value2) {
            addCriterion("xyimg not between", value1, value2, "xyimg");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeIsNull() {
            addCriterion("xyaddtime is null");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeIsNotNull() {
            addCriterion("xyaddtime is not null");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeEqualTo(String value) {
            addCriterion("xyaddtime =", value, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeNotEqualTo(String value) {
            addCriterion("xyaddtime <>", value, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeGreaterThan(String value) {
            addCriterion("xyaddtime >", value, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("xyaddtime >=", value, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeLessThan(String value) {
            addCriterion("xyaddtime <", value, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeLessThanOrEqualTo(String value) {
            addCriterion("xyaddtime <=", value, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeLike(String value) {
            addCriterion("xyaddtime like", value, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeNotLike(String value) {
            addCriterion("xyaddtime not like", value, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeIn(List<String> values) {
            addCriterion("xyaddtime in", values, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeNotIn(List<String> values) {
            addCriterion("xyaddtime not in", values, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeBetween(String value1, String value2) {
            addCriterion("xyaddtime between", value1, value2, "xyaddtime");
            return (Criteria) this;
        }

        public Criteria andXyaddtimeNotBetween(String value1, String value2) {
            addCriterion("xyaddtime not between", value1, value2, "xyaddtime");
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
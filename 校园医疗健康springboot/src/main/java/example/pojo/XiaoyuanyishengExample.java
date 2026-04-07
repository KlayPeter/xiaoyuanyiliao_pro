package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class XiaoyuanyishengExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XiaoyuanyishengExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameIsNull() {
            addCriterion("schoolyishengname is null");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameIsNotNull() {
            addCriterion("schoolyishengname is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameEqualTo(String value) {
            addCriterion("schoolyishengname =", value, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameNotEqualTo(String value) {
            addCriterion("schoolyishengname <>", value, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameGreaterThan(String value) {
            addCriterion("schoolyishengname >", value, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameGreaterThanOrEqualTo(String value) {
            addCriterion("schoolyishengname >=", value, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameLessThan(String value) {
            addCriterion("schoolyishengname <", value, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameLessThanOrEqualTo(String value) {
            addCriterion("schoolyishengname <=", value, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameLike(String value) {
            addCriterion("schoolyishengname like", value, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameNotLike(String value) {
            addCriterion("schoolyishengname not like", value, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameIn(List<String> values) {
            addCriterion("schoolyishengname in", values, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameNotIn(List<String> values) {
            addCriterion("schoolyishengname not in", values, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameBetween(String value1, String value2) {
            addCriterion("schoolyishengname between", value1, value2, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyishengnameNotBetween(String value1, String value2) {
            addCriterion("schoolyishengname not between", value1, value2, "schoolyishengname");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexIsNull() {
            addCriterion("schoolyssex is null");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexIsNotNull() {
            addCriterion("schoolyssex is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexEqualTo(String value) {
            addCriterion("schoolyssex =", value, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexNotEqualTo(String value) {
            addCriterion("schoolyssex <>", value, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexGreaterThan(String value) {
            addCriterion("schoolyssex >", value, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexGreaterThanOrEqualTo(String value) {
            addCriterion("schoolyssex >=", value, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexLessThan(String value) {
            addCriterion("schoolyssex <", value, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexLessThanOrEqualTo(String value) {
            addCriterion("schoolyssex <=", value, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexLike(String value) {
            addCriterion("schoolyssex like", value, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexNotLike(String value) {
            addCriterion("schoolyssex not like", value, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexIn(List<String> values) {
            addCriterion("schoolyssex in", values, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexNotIn(List<String> values) {
            addCriterion("schoolyssex not in", values, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexBetween(String value1, String value2) {
            addCriterion("schoolyssex between", value1, value2, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolyssexNotBetween(String value1, String value2) {
            addCriterion("schoolyssex not between", value1, value2, "schoolyssex");
            return (Criteria) this;
        }

        public Criteria andSchoolysageIsNull() {
            addCriterion("schoolysage is null");
            return (Criteria) this;
        }

        public Criteria andSchoolysageIsNotNull() {
            addCriterion("schoolysage is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolysageEqualTo(String value) {
            addCriterion("schoolysage =", value, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageNotEqualTo(String value) {
            addCriterion("schoolysage <>", value, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageGreaterThan(String value) {
            addCriterion("schoolysage >", value, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageGreaterThanOrEqualTo(String value) {
            addCriterion("schoolysage >=", value, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageLessThan(String value) {
            addCriterion("schoolysage <", value, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageLessThanOrEqualTo(String value) {
            addCriterion("schoolysage <=", value, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageLike(String value) {
            addCriterion("schoolysage like", value, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageNotLike(String value) {
            addCriterion("schoolysage not like", value, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageIn(List<String> values) {
            addCriterion("schoolysage in", values, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageNotIn(List<String> values) {
            addCriterion("schoolysage not in", values, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageBetween(String value1, String value2) {
            addCriterion("schoolysage between", value1, value2, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysageNotBetween(String value1, String value2) {
            addCriterion("schoolysage not between", value1, value2, "schoolysage");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneIsNull() {
            addCriterion("schoolysphone is null");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneIsNotNull() {
            addCriterion("schoolysphone is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneEqualTo(String value) {
            addCriterion("schoolysphone =", value, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneNotEqualTo(String value) {
            addCriterion("schoolysphone <>", value, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneGreaterThan(String value) {
            addCriterion("schoolysphone >", value, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneGreaterThanOrEqualTo(String value) {
            addCriterion("schoolysphone >=", value, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneLessThan(String value) {
            addCriterion("schoolysphone <", value, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneLessThanOrEqualTo(String value) {
            addCriterion("schoolysphone <=", value, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneLike(String value) {
            addCriterion("schoolysphone like", value, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneNotLike(String value) {
            addCriterion("schoolysphone not like", value, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneIn(List<String> values) {
            addCriterion("schoolysphone in", values, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneNotIn(List<String> values) {
            addCriterion("schoolysphone not in", values, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneBetween(String value1, String value2) {
            addCriterion("schoolysphone between", value1, value2, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysphoneNotBetween(String value1, String value2) {
            addCriterion("schoolysphone not between", value1, value2, "schoolysphone");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorIsNull() {
            addCriterion("schoolysavaator is null");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorIsNotNull() {
            addCriterion("schoolysavaator is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorEqualTo(String value) {
            addCriterion("schoolysavaator =", value, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorNotEqualTo(String value) {
            addCriterion("schoolysavaator <>", value, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorGreaterThan(String value) {
            addCriterion("schoolysavaator >", value, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorGreaterThanOrEqualTo(String value) {
            addCriterion("schoolysavaator >=", value, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorLessThan(String value) {
            addCriterion("schoolysavaator <", value, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorLessThanOrEqualTo(String value) {
            addCriterion("schoolysavaator <=", value, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorLike(String value) {
            addCriterion("schoolysavaator like", value, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorNotLike(String value) {
            addCriterion("schoolysavaator not like", value, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorIn(List<String> values) {
            addCriterion("schoolysavaator in", values, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorNotIn(List<String> values) {
            addCriterion("schoolysavaator not in", values, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorBetween(String value1, String value2) {
            addCriterion("schoolysavaator between", value1, value2, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysavaatorNotBetween(String value1, String value2) {
            addCriterion("schoolysavaator not between", value1, value2, "schoolysavaator");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieIsNull() {
            addCriterion("schoolysjianjie is null");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieIsNotNull() {
            addCriterion("schoolysjianjie is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieEqualTo(String value) {
            addCriterion("schoolysjianjie =", value, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieNotEqualTo(String value) {
            addCriterion("schoolysjianjie <>", value, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieGreaterThan(String value) {
            addCriterion("schoolysjianjie >", value, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieGreaterThanOrEqualTo(String value) {
            addCriterion("schoolysjianjie >=", value, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieLessThan(String value) {
            addCriterion("schoolysjianjie <", value, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieLessThanOrEqualTo(String value) {
            addCriterion("schoolysjianjie <=", value, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieLike(String value) {
            addCriterion("schoolysjianjie like", value, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieNotLike(String value) {
            addCriterion("schoolysjianjie not like", value, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieIn(List<String> values) {
            addCriterion("schoolysjianjie in", values, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieNotIn(List<String> values) {
            addCriterion("schoolysjianjie not in", values, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieBetween(String value1, String value2) {
            addCriterion("schoolysjianjie between", value1, value2, "schoolysjianjie");
            return (Criteria) this;
        }

        public Criteria andSchoolysjianjieNotBetween(String value1, String value2) {
            addCriterion("schoolysjianjie not between", value1, value2, "schoolysjianjie");
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
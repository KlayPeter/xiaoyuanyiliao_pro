package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class XyyiliaoyhExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XyyiliaoyhExample() {
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

        public Criteria andXyyiliaoyhnameIsNull() {
            addCriterion("xyyiliaoyhname is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameIsNotNull() {
            addCriterion("xyyiliaoyhname is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameEqualTo(String value) {
            addCriterion("xyyiliaoyhname =", value, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameNotEqualTo(String value) {
            addCriterion("xyyiliaoyhname <>", value, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameGreaterThan(String value) {
            addCriterion("xyyiliaoyhname >", value, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameGreaterThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhname >=", value, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameLessThan(String value) {
            addCriterion("xyyiliaoyhname <", value, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameLessThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhname <=", value, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameLike(String value) {
            addCriterion("xyyiliaoyhname like", value, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameNotLike(String value) {
            addCriterion("xyyiliaoyhname not like", value, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameIn(List<String> values) {
            addCriterion("xyyiliaoyhname in", values, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameNotIn(List<String> values) {
            addCriterion("xyyiliaoyhname not in", values, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhname between", value1, value2, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhnameNotBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhname not between", value1, value2, "xyyiliaoyhname");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexIsNull() {
            addCriterion("xyyiliaoyhsex is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexIsNotNull() {
            addCriterion("xyyiliaoyhsex is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexEqualTo(String value) {
            addCriterion("xyyiliaoyhsex =", value, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexNotEqualTo(String value) {
            addCriterion("xyyiliaoyhsex <>", value, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexGreaterThan(String value) {
            addCriterion("xyyiliaoyhsex >", value, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexGreaterThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhsex >=", value, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexLessThan(String value) {
            addCriterion("xyyiliaoyhsex <", value, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexLessThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhsex <=", value, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexLike(String value) {
            addCriterion("xyyiliaoyhsex like", value, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexNotLike(String value) {
            addCriterion("xyyiliaoyhsex not like", value, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexIn(List<String> values) {
            addCriterion("xyyiliaoyhsex in", values, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexNotIn(List<String> values) {
            addCriterion("xyyiliaoyhsex not in", values, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhsex between", value1, value2, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhsexNotBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhsex not between", value1, value2, "xyyiliaoyhsex");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageIsNull() {
            addCriterion("xyyiliaoyhage is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageIsNotNull() {
            addCriterion("xyyiliaoyhage is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageEqualTo(String value) {
            addCriterion("xyyiliaoyhage =", value, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageNotEqualTo(String value) {
            addCriterion("xyyiliaoyhage <>", value, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageGreaterThan(String value) {
            addCriterion("xyyiliaoyhage >", value, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageGreaterThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhage >=", value, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageLessThan(String value) {
            addCriterion("xyyiliaoyhage <", value, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageLessThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhage <=", value, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageLike(String value) {
            addCriterion("xyyiliaoyhage like", value, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageNotLike(String value) {
            addCriterion("xyyiliaoyhage not like", value, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageIn(List<String> values) {
            addCriterion("xyyiliaoyhage in", values, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageNotIn(List<String> values) {
            addCriterion("xyyiliaoyhage not in", values, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhage between", value1, value2, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhageNotBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhage not between", value1, value2, "xyyiliaoyhage");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneIsNull() {
            addCriterion("xyyiliaoyhphone is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneIsNotNull() {
            addCriterion("xyyiliaoyhphone is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneEqualTo(String value) {
            addCriterion("xyyiliaoyhphone =", value, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneNotEqualTo(String value) {
            addCriterion("xyyiliaoyhphone <>", value, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneGreaterThan(String value) {
            addCriterion("xyyiliaoyhphone >", value, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneGreaterThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhphone >=", value, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneLessThan(String value) {
            addCriterion("xyyiliaoyhphone <", value, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneLessThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhphone <=", value, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneLike(String value) {
            addCriterion("xyyiliaoyhphone like", value, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneNotLike(String value) {
            addCriterion("xyyiliaoyhphone not like", value, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneIn(List<String> values) {
            addCriterion("xyyiliaoyhphone in", values, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneNotIn(List<String> values) {
            addCriterion("xyyiliaoyhphone not in", values, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhphone between", value1, value2, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhphoneNotBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhphone not between", value1, value2, "xyyiliaoyhphone");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgIsNull() {
            addCriterion("xyyiliaoyhimg is null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgIsNotNull() {
            addCriterion("xyyiliaoyhimg is not null");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgEqualTo(String value) {
            addCriterion("xyyiliaoyhimg =", value, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgNotEqualTo(String value) {
            addCriterion("xyyiliaoyhimg <>", value, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgGreaterThan(String value) {
            addCriterion("xyyiliaoyhimg >", value, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgGreaterThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhimg >=", value, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgLessThan(String value) {
            addCriterion("xyyiliaoyhimg <", value, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgLessThanOrEqualTo(String value) {
            addCriterion("xyyiliaoyhimg <=", value, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgLike(String value) {
            addCriterion("xyyiliaoyhimg like", value, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgNotLike(String value) {
            addCriterion("xyyiliaoyhimg not like", value, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgIn(List<String> values) {
            addCriterion("xyyiliaoyhimg in", values, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgNotIn(List<String> values) {
            addCriterion("xyyiliaoyhimg not in", values, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhimg between", value1, value2, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andXyyiliaoyhimgNotBetween(String value1, String value2) {
            addCriterion("xyyiliaoyhimg not between", value1, value2, "xyyiliaoyhimg");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("college is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("college is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("college =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("college <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("college >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("college >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("college <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("college <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("college like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("college not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("college in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("college not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("college between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("college not between", value1, value2, "college");
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
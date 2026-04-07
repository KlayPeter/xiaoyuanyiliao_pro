package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class XytijianshixiangExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XytijianshixiangExample() {
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

        public Criteria andTijiantIsNull() {
            addCriterion("tijiant is null");
            return (Criteria) this;
        }

        public Criteria andTijiantIsNotNull() {
            addCriterion("tijiant is not null");
            return (Criteria) this;
        }

        public Criteria andTijiantEqualTo(String value) {
            addCriterion("tijiant =", value, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantNotEqualTo(String value) {
            addCriterion("tijiant <>", value, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantGreaterThan(String value) {
            addCriterion("tijiant >", value, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantGreaterThanOrEqualTo(String value) {
            addCriterion("tijiant >=", value, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantLessThan(String value) {
            addCriterion("tijiant <", value, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantLessThanOrEqualTo(String value) {
            addCriterion("tijiant <=", value, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantLike(String value) {
            addCriterion("tijiant like", value, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantNotLike(String value) {
            addCriterion("tijiant not like", value, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantIn(List<String> values) {
            addCriterion("tijiant in", values, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantNotIn(List<String> values) {
            addCriterion("tijiant not in", values, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantBetween(String value1, String value2) {
            addCriterion("tijiant between", value1, value2, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiantNotBetween(String value1, String value2) {
            addCriterion("tijiant not between", value1, value2, "tijiant");
            return (Criteria) this;
        }

        public Criteria andTijiancontentIsNull() {
            addCriterion("tijiancontent is null");
            return (Criteria) this;
        }

        public Criteria andTijiancontentIsNotNull() {
            addCriterion("tijiancontent is not null");
            return (Criteria) this;
        }

        public Criteria andTijiancontentEqualTo(String value) {
            addCriterion("tijiancontent =", value, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentNotEqualTo(String value) {
            addCriterion("tijiancontent <>", value, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentGreaterThan(String value) {
            addCriterion("tijiancontent >", value, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentGreaterThanOrEqualTo(String value) {
            addCriterion("tijiancontent >=", value, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentLessThan(String value) {
            addCriterion("tijiancontent <", value, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentLessThanOrEqualTo(String value) {
            addCriterion("tijiancontent <=", value, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentLike(String value) {
            addCriterion("tijiancontent like", value, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentNotLike(String value) {
            addCriterion("tijiancontent not like", value, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentIn(List<String> values) {
            addCriterion("tijiancontent in", values, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentNotIn(List<String> values) {
            addCriterion("tijiancontent not in", values, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentBetween(String value1, String value2) {
            addCriterion("tijiancontent between", value1, value2, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijiancontentNotBetween(String value1, String value2) {
            addCriterion("tijiancontent not between", value1, value2, "tijiancontent");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiIsNull() {
            addCriterion("tijianzhuyi is null");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiIsNotNull() {
            addCriterion("tijianzhuyi is not null");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiEqualTo(String value) {
            addCriterion("tijianzhuyi =", value, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiNotEqualTo(String value) {
            addCriterion("tijianzhuyi <>", value, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiGreaterThan(String value) {
            addCriterion("tijianzhuyi >", value, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiGreaterThanOrEqualTo(String value) {
            addCriterion("tijianzhuyi >=", value, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiLessThan(String value) {
            addCriterion("tijianzhuyi <", value, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiLessThanOrEqualTo(String value) {
            addCriterion("tijianzhuyi <=", value, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiLike(String value) {
            addCriterion("tijianzhuyi like", value, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiNotLike(String value) {
            addCriterion("tijianzhuyi not like", value, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiIn(List<String> values) {
            addCriterion("tijianzhuyi in", values, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiNotIn(List<String> values) {
            addCriterion("tijianzhuyi not in", values, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiBetween(String value1, String value2) {
            addCriterion("tijianzhuyi between", value1, value2, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianzhuyiNotBetween(String value1, String value2) {
            addCriterion("tijianzhuyi not between", value1, value2, "tijianzhuyi");
            return (Criteria) this;
        }

        public Criteria andTijianadressIsNull() {
            addCriterion("tijianadress is null");
            return (Criteria) this;
        }

        public Criteria andTijianadressIsNotNull() {
            addCriterion("tijianadress is not null");
            return (Criteria) this;
        }

        public Criteria andTijianadressEqualTo(String value) {
            addCriterion("tijianadress =", value, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressNotEqualTo(String value) {
            addCriterion("tijianadress <>", value, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressGreaterThan(String value) {
            addCriterion("tijianadress >", value, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressGreaterThanOrEqualTo(String value) {
            addCriterion("tijianadress >=", value, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressLessThan(String value) {
            addCriterion("tijianadress <", value, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressLessThanOrEqualTo(String value) {
            addCriterion("tijianadress <=", value, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressLike(String value) {
            addCriterion("tijianadress like", value, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressNotLike(String value) {
            addCriterion("tijianadress not like", value, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressIn(List<String> values) {
            addCriterion("tijianadress in", values, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressNotIn(List<String> values) {
            addCriterion("tijianadress not in", values, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressBetween(String value1, String value2) {
            addCriterion("tijianadress between", value1, value2, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijianadressNotBetween(String value1, String value2) {
            addCriterion("tijianadress not between", value1, value2, "tijianadress");
            return (Criteria) this;
        }

        public Criteria andTijiantimeIsNull() {
            addCriterion("tijiantime is null");
            return (Criteria) this;
        }

        public Criteria andTijiantimeIsNotNull() {
            addCriterion("tijiantime is not null");
            return (Criteria) this;
        }

        public Criteria andTijiantimeEqualTo(String value) {
            addCriterion("tijiantime =", value, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeNotEqualTo(String value) {
            addCriterion("tijiantime <>", value, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeGreaterThan(String value) {
            addCriterion("tijiantime >", value, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeGreaterThanOrEqualTo(String value) {
            addCriterion("tijiantime >=", value, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeLessThan(String value) {
            addCriterion("tijiantime <", value, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeLessThanOrEqualTo(String value) {
            addCriterion("tijiantime <=", value, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeLike(String value) {
            addCriterion("tijiantime like", value, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeNotLike(String value) {
            addCriterion("tijiantime not like", value, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeIn(List<String> values) {
            addCriterion("tijiantime in", values, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeNotIn(List<String> values) {
            addCriterion("tijiantime not in", values, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeBetween(String value1, String value2) {
            addCriterion("tijiantime between", value1, value2, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijiantimeNotBetween(String value1, String value2) {
            addCriterion("tijiantime not between", value1, value2, "tijiantime");
            return (Criteria) this;
        }

        public Criteria andTijianimgIsNull() {
            addCriterion("tijianimg is null");
            return (Criteria) this;
        }

        public Criteria andTijianimgIsNotNull() {
            addCriterion("tijianimg is not null");
            return (Criteria) this;
        }

        public Criteria andTijianimgEqualTo(String value) {
            addCriterion("tijianimg =", value, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgNotEqualTo(String value) {
            addCriterion("tijianimg <>", value, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgGreaterThan(String value) {
            addCriterion("tijianimg >", value, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgGreaterThanOrEqualTo(String value) {
            addCriterion("tijianimg >=", value, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgLessThan(String value) {
            addCriterion("tijianimg <", value, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgLessThanOrEqualTo(String value) {
            addCriterion("tijianimg <=", value, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgLike(String value) {
            addCriterion("tijianimg like", value, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgNotLike(String value) {
            addCriterion("tijianimg not like", value, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgIn(List<String> values) {
            addCriterion("tijianimg in", values, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgNotIn(List<String> values) {
            addCriterion("tijianimg not in", values, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgBetween(String value1, String value2) {
            addCriterion("tijianimg between", value1, value2, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andTijianimgNotBetween(String value1, String value2) {
            addCriterion("tijianimg not between", value1, value2, "tijianimg");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengIsNull() {
            addCriterion("xiaoyuanyisheng is null");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengIsNotNull() {
            addCriterion("xiaoyuanyisheng is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengEqualTo(String value) {
            addCriterion("xiaoyuanyisheng =", value, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengNotEqualTo(String value) {
            addCriterion("xiaoyuanyisheng <>", value, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengGreaterThan(String value) {
            addCriterion("xiaoyuanyisheng >", value, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoyuanyisheng >=", value, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengLessThan(String value) {
            addCriterion("xiaoyuanyisheng <", value, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengLessThanOrEqualTo(String value) {
            addCriterion("xiaoyuanyisheng <=", value, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengLike(String value) {
            addCriterion("xiaoyuanyisheng like", value, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengNotLike(String value) {
            addCriterion("xiaoyuanyisheng not like", value, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengIn(List<String> values) {
            addCriterion("xiaoyuanyisheng in", values, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengNotIn(List<String> values) {
            addCriterion("xiaoyuanyisheng not in", values, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengBetween(String value1, String value2) {
            addCriterion("xiaoyuanyisheng between", value1, value2, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengNotBetween(String value1, String value2) {
            addCriterion("xiaoyuanyisheng not between", value1, value2, "xiaoyuanyisheng");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidIsNull() {
            addCriterion("xiaoyuanyishengid is null");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidIsNotNull() {
            addCriterion("xiaoyuanyishengid is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidEqualTo(Integer value) {
            addCriterion("xiaoyuanyishengid =", value, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidNotEqualTo(Integer value) {
            addCriterion("xiaoyuanyishengid <>", value, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidGreaterThan(Integer value) {
            addCriterion("xiaoyuanyishengid >", value, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidGreaterThanOrEqualTo(Integer value) {
            addCriterion("xiaoyuanyishengid >=", value, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidLessThan(Integer value) {
            addCriterion("xiaoyuanyishengid <", value, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidLessThanOrEqualTo(Integer value) {
            addCriterion("xiaoyuanyishengid <=", value, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidIn(List<Integer> values) {
            addCriterion("xiaoyuanyishengid in", values, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidNotIn(List<Integer> values) {
            addCriterion("xiaoyuanyishengid not in", values, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidBetween(Integer value1, Integer value2) {
            addCriterion("xiaoyuanyishengid between", value1, value2, "xiaoyuanyishengid");
            return (Criteria) this;
        }

        public Criteria andXiaoyuanyishengidNotBetween(Integer value1, Integer value2) {
            addCriterion("xiaoyuanyishengid not between", value1, value2, "xiaoyuanyishengid");
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
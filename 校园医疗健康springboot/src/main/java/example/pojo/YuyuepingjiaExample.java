package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class YuyuepingjiaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YuyuepingjiaExample() {
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

        public Criteria andPingcontentIsNull() {
            addCriterion("pingcontent is null");
            return (Criteria) this;
        }

        public Criteria andPingcontentIsNotNull() {
            addCriterion("pingcontent is not null");
            return (Criteria) this;
        }

        public Criteria andPingcontentEqualTo(String value) {
            addCriterion("pingcontent =", value, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentNotEqualTo(String value) {
            addCriterion("pingcontent <>", value, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentGreaterThan(String value) {
            addCriterion("pingcontent >", value, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentGreaterThanOrEqualTo(String value) {
            addCriterion("pingcontent >=", value, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentLessThan(String value) {
            addCriterion("pingcontent <", value, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentLessThanOrEqualTo(String value) {
            addCriterion("pingcontent <=", value, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentLike(String value) {
            addCriterion("pingcontent like", value, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentNotLike(String value) {
            addCriterion("pingcontent not like", value, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentIn(List<String> values) {
            addCriterion("pingcontent in", values, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentNotIn(List<String> values) {
            addCriterion("pingcontent not in", values, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentBetween(String value1, String value2) {
            addCriterion("pingcontent between", value1, value2, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andPingcontentNotBetween(String value1, String value2) {
            addCriterion("pingcontent not between", value1, value2, "pingcontent");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andPingjiashijianIsNull() {
            addCriterion("pingjiashijian is null");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianIsNotNull() {
            addCriterion("pingjiashijian is not null");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianEqualTo(String value) {
            addCriterion("pingjiashijian =", value, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianNotEqualTo(String value) {
            addCriterion("pingjiashijian <>", value, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianGreaterThan(String value) {
            addCriterion("pingjiashijian >", value, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianGreaterThanOrEqualTo(String value) {
            addCriterion("pingjiashijian >=", value, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianLessThan(String value) {
            addCriterion("pingjiashijian <", value, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianLessThanOrEqualTo(String value) {
            addCriterion("pingjiashijian <=", value, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianLike(String value) {
            addCriterion("pingjiashijian like", value, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianNotLike(String value) {
            addCriterion("pingjiashijian not like", value, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianIn(List<String> values) {
            addCriterion("pingjiashijian in", values, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianNotIn(List<String> values) {
            addCriterion("pingjiashijian not in", values, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianBetween(String value1, String value2) {
            addCriterion("pingjiashijian between", value1, value2, "pingjiashijian");
            return (Criteria) this;
        }

        public Criteria andPingjiashijianNotBetween(String value1, String value2) {
            addCriterion("pingjiashijian not between", value1, value2, "pingjiashijian");
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
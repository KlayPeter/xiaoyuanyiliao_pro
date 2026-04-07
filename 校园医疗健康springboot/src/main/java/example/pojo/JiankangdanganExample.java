package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class JiankangdanganExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JiankangdanganExample() {
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

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLike(String value) {
            addCriterion("weight like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("weight not like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<String> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<String> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andBmiIsNull() {
            addCriterion("bmi is null");
            return (Criteria) this;
        }

        public Criteria andBmiIsNotNull() {
            addCriterion("bmi is not null");
            return (Criteria) this;
        }

        public Criteria andBmiEqualTo(String value) {
            addCriterion("bmi =", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotEqualTo(String value) {
            addCriterion("bmi <>", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThan(String value) {
            addCriterion("bmi >", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThanOrEqualTo(String value) {
            addCriterion("bmi >=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThan(String value) {
            addCriterion("bmi <", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThanOrEqualTo(String value) {
            addCriterion("bmi <=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLike(String value) {
            addCriterion("bmi like", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotLike(String value) {
            addCriterion("bmi not like", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiIn(List<String> values) {
            addCriterion("bmi in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotIn(List<String> values) {
            addCriterion("bmi not in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiBetween(String value1, String value2) {
            addCriterion("bmi between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotBetween(String value1, String value2) {
            addCriterion("bmi not between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliIsNull() {
            addCriterion("zuoyanshili is null");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliIsNotNull() {
            addCriterion("zuoyanshili is not null");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliEqualTo(String value) {
            addCriterion("zuoyanshili =", value, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliNotEqualTo(String value) {
            addCriterion("zuoyanshili <>", value, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliGreaterThan(String value) {
            addCriterion("zuoyanshili >", value, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliGreaterThanOrEqualTo(String value) {
            addCriterion("zuoyanshili >=", value, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliLessThan(String value) {
            addCriterion("zuoyanshili <", value, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliLessThanOrEqualTo(String value) {
            addCriterion("zuoyanshili <=", value, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliLike(String value) {
            addCriterion("zuoyanshili like", value, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliNotLike(String value) {
            addCriterion("zuoyanshili not like", value, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliIn(List<String> values) {
            addCriterion("zuoyanshili in", values, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliNotIn(List<String> values) {
            addCriterion("zuoyanshili not in", values, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliBetween(String value1, String value2) {
            addCriterion("zuoyanshili between", value1, value2, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andZuoyanshiliNotBetween(String value1, String value2) {
            addCriterion("zuoyanshili not between", value1, value2, "zuoyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliIsNull() {
            addCriterion("youyanshili is null");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliIsNotNull() {
            addCriterion("youyanshili is not null");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliEqualTo(String value) {
            addCriterion("youyanshili =", value, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliNotEqualTo(String value) {
            addCriterion("youyanshili <>", value, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliGreaterThan(String value) {
            addCriterion("youyanshili >", value, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliGreaterThanOrEqualTo(String value) {
            addCriterion("youyanshili >=", value, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliLessThan(String value) {
            addCriterion("youyanshili <", value, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliLessThanOrEqualTo(String value) {
            addCriterion("youyanshili <=", value, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliLike(String value) {
            addCriterion("youyanshili like", value, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliNotLike(String value) {
            addCriterion("youyanshili not like", value, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliIn(List<String> values) {
            addCriterion("youyanshili in", values, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliNotIn(List<String> values) {
            addCriterion("youyanshili not in", values, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliBetween(String value1, String value2) {
            addCriterion("youyanshili between", value1, value2, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andYouyanshiliNotBetween(String value1, String value2) {
            addCriterion("youyanshili not between", value1, value2, "youyanshili");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangIsNull() {
            addCriterion("feihuoliang is null");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangIsNotNull() {
            addCriterion("feihuoliang is not null");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangEqualTo(String value) {
            addCriterion("feihuoliang =", value, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangNotEqualTo(String value) {
            addCriterion("feihuoliang <>", value, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangGreaterThan(String value) {
            addCriterion("feihuoliang >", value, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangGreaterThanOrEqualTo(String value) {
            addCriterion("feihuoliang >=", value, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangLessThan(String value) {
            addCriterion("feihuoliang <", value, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangLessThanOrEqualTo(String value) {
            addCriterion("feihuoliang <=", value, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangLike(String value) {
            addCriterion("feihuoliang like", value, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangNotLike(String value) {
            addCriterion("feihuoliang not like", value, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangIn(List<String> values) {
            addCriterion("feihuoliang in", values, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangNotIn(List<String> values) {
            addCriterion("feihuoliang not in", values, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangBetween(String value1, String value2) {
            addCriterion("feihuoliang between", value1, value2, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andFeihuoliangNotBetween(String value1, String value2) {
            addCriterion("feihuoliang not between", value1, value2, "feihuoliang");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanIsNull() {
            addCriterion("lidingtiaoyuan is null");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanIsNotNull() {
            addCriterion("lidingtiaoyuan is not null");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanEqualTo(String value) {
            addCriterion("lidingtiaoyuan =", value, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanNotEqualTo(String value) {
            addCriterion("lidingtiaoyuan <>", value, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanGreaterThan(String value) {
            addCriterion("lidingtiaoyuan >", value, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanGreaterThanOrEqualTo(String value) {
            addCriterion("lidingtiaoyuan >=", value, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanLessThan(String value) {
            addCriterion("lidingtiaoyuan <", value, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanLessThanOrEqualTo(String value) {
            addCriterion("lidingtiaoyuan <=", value, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanLike(String value) {
            addCriterion("lidingtiaoyuan like", value, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanNotLike(String value) {
            addCriterion("lidingtiaoyuan not like", value, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanIn(List<String> values) {
            addCriterion("lidingtiaoyuan in", values, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanNotIn(List<String> values) {
            addCriterion("lidingtiaoyuan not in", values, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanBetween(String value1, String value2) {
            addCriterion("lidingtiaoyuan between", value1, value2, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andLidingtiaoyuanNotBetween(String value1, String value2) {
            addCriterion("lidingtiaoyuan not between", value1, value2, "lidingtiaoyuan");
            return (Criteria) this;
        }

        public Criteria andYibaimiIsNull() {
            addCriterion("yibaimi is null");
            return (Criteria) this;
        }

        public Criteria andYibaimiIsNotNull() {
            addCriterion("yibaimi is not null");
            return (Criteria) this;
        }

        public Criteria andYibaimiEqualTo(String value) {
            addCriterion("yibaimi =", value, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiNotEqualTo(String value) {
            addCriterion("yibaimi <>", value, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiGreaterThan(String value) {
            addCriterion("yibaimi >", value, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiGreaterThanOrEqualTo(String value) {
            addCriterion("yibaimi >=", value, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiLessThan(String value) {
            addCriterion("yibaimi <", value, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiLessThanOrEqualTo(String value) {
            addCriterion("yibaimi <=", value, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiLike(String value) {
            addCriterion("yibaimi like", value, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiNotLike(String value) {
            addCriterion("yibaimi not like", value, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiIn(List<String> values) {
            addCriterion("yibaimi in", values, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiNotIn(List<String> values) {
            addCriterion("yibaimi not in", values, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiBetween(String value1, String value2) {
            addCriterion("yibaimi between", value1, value2, "yibaimi");
            return (Criteria) this;
        }

        public Criteria andYibaimiNotBetween(String value1, String value2) {
            addCriterion("yibaimi not between", value1, value2, "yibaimi");
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
package example.pojo;

import java.util.ArrayList;
import java.util.List;

public class GuahaozixunjieguoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuahaozixunjieguoExample() {
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

        public Criteria andKaifangtimeIsNull() {
            addCriterion("kaifangtime is null");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeIsNotNull() {
            addCriterion("kaifangtime is not null");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeEqualTo(String value) {
            addCriterion("kaifangtime =", value, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeNotEqualTo(String value) {
            addCriterion("kaifangtime <>", value, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeGreaterThan(String value) {
            addCriterion("kaifangtime >", value, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeGreaterThanOrEqualTo(String value) {
            addCriterion("kaifangtime >=", value, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeLessThan(String value) {
            addCriterion("kaifangtime <", value, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeLessThanOrEqualTo(String value) {
            addCriterion("kaifangtime <=", value, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeLike(String value) {
            addCriterion("kaifangtime like", value, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeNotLike(String value) {
            addCriterion("kaifangtime not like", value, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeIn(List<String> values) {
            addCriterion("kaifangtime in", values, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeNotIn(List<String> values) {
            addCriterion("kaifangtime not in", values, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeBetween(String value1, String value2) {
            addCriterion("kaifangtime between", value1, value2, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andKaifangtimeNotBetween(String value1, String value2) {
            addCriterion("kaifangtime not between", value1, value2, "kaifangtime");
            return (Criteria) this;
        }

        public Criteria andZhusuIsNull() {
            addCriterion("zhusu is null");
            return (Criteria) this;
        }

        public Criteria andZhusuIsNotNull() {
            addCriterion("zhusu is not null");
            return (Criteria) this;
        }

        public Criteria andZhusuEqualTo(String value) {
            addCriterion("zhusu =", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuNotEqualTo(String value) {
            addCriterion("zhusu <>", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuGreaterThan(String value) {
            addCriterion("zhusu >", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuGreaterThanOrEqualTo(String value) {
            addCriterion("zhusu >=", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuLessThan(String value) {
            addCriterion("zhusu <", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuLessThanOrEqualTo(String value) {
            addCriterion("zhusu <=", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuLike(String value) {
            addCriterion("zhusu like", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuNotLike(String value) {
            addCriterion("zhusu not like", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuIn(List<String> values) {
            addCriterion("zhusu in", values, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuNotIn(List<String> values) {
            addCriterion("zhusu not in", values, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuBetween(String value1, String value2) {
            addCriterion("zhusu between", value1, value2, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuNotBetween(String value1, String value2) {
            addCriterion("zhusu not between", value1, value2, "zhusu");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenIsNull() {
            addCriterion("yonghutiwen is null");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenIsNotNull() {
            addCriterion("yonghutiwen is not null");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenEqualTo(String value) {
            addCriterion("yonghutiwen =", value, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenNotEqualTo(String value) {
            addCriterion("yonghutiwen <>", value, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenGreaterThan(String value) {
            addCriterion("yonghutiwen >", value, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenGreaterThanOrEqualTo(String value) {
            addCriterion("yonghutiwen >=", value, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenLessThan(String value) {
            addCriterion("yonghutiwen <", value, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenLessThanOrEqualTo(String value) {
            addCriterion("yonghutiwen <=", value, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenLike(String value) {
            addCriterion("yonghutiwen like", value, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenNotLike(String value) {
            addCriterion("yonghutiwen not like", value, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenIn(List<String> values) {
            addCriterion("yonghutiwen in", values, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenNotIn(List<String> values) {
            addCriterion("yonghutiwen not in", values, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenBetween(String value1, String value2) {
            addCriterion("yonghutiwen between", value1, value2, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andYonghutiwenNotBetween(String value1, String value2) {
            addCriterion("yonghutiwen not between", value1, value2, "yonghutiwen");
            return (Criteria) this;
        }

        public Criteria andXinlvIsNull() {
            addCriterion("xinlv is null");
            return (Criteria) this;
        }

        public Criteria andXinlvIsNotNull() {
            addCriterion("xinlv is not null");
            return (Criteria) this;
        }

        public Criteria andXinlvEqualTo(String value) {
            addCriterion("xinlv =", value, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvNotEqualTo(String value) {
            addCriterion("xinlv <>", value, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvGreaterThan(String value) {
            addCriterion("xinlv >", value, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvGreaterThanOrEqualTo(String value) {
            addCriterion("xinlv >=", value, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvLessThan(String value) {
            addCriterion("xinlv <", value, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvLessThanOrEqualTo(String value) {
            addCriterion("xinlv <=", value, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvLike(String value) {
            addCriterion("xinlv like", value, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvNotLike(String value) {
            addCriterion("xinlv not like", value, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvIn(List<String> values) {
            addCriterion("xinlv in", values, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvNotIn(List<String> values) {
            addCriterion("xinlv not in", values, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvBetween(String value1, String value2) {
            addCriterion("xinlv between", value1, value2, "xinlv");
            return (Criteria) this;
        }

        public Criteria andXinlvNotBetween(String value1, String value2) {
            addCriterion("xinlv not between", value1, value2, "xinlv");
            return (Criteria) this;
        }

        public Criteria andZhenduanIsNull() {
            addCriterion("zhenduan is null");
            return (Criteria) this;
        }

        public Criteria andZhenduanIsNotNull() {
            addCriterion("zhenduan is not null");
            return (Criteria) this;
        }

        public Criteria andZhenduanEqualTo(String value) {
            addCriterion("zhenduan =", value, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanNotEqualTo(String value) {
            addCriterion("zhenduan <>", value, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanGreaterThan(String value) {
            addCriterion("zhenduan >", value, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanGreaterThanOrEqualTo(String value) {
            addCriterion("zhenduan >=", value, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanLessThan(String value) {
            addCriterion("zhenduan <", value, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanLessThanOrEqualTo(String value) {
            addCriterion("zhenduan <=", value, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanLike(String value) {
            addCriterion("zhenduan like", value, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanNotLike(String value) {
            addCriterion("zhenduan not like", value, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanIn(List<String> values) {
            addCriterion("zhenduan in", values, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanNotIn(List<String> values) {
            addCriterion("zhenduan not in", values, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanBetween(String value1, String value2) {
            addCriterion("zhenduan between", value1, value2, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andZhenduanNotBetween(String value1, String value2) {
            addCriterion("zhenduan not between", value1, value2, "zhenduan");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyIsNull() {
            addCriterion("xiuxijiany is null");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyIsNotNull() {
            addCriterion("xiuxijiany is not null");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyEqualTo(String value) {
            addCriterion("xiuxijiany =", value, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyNotEqualTo(String value) {
            addCriterion("xiuxijiany <>", value, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyGreaterThan(String value) {
            addCriterion("xiuxijiany >", value, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyGreaterThanOrEqualTo(String value) {
            addCriterion("xiuxijiany >=", value, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyLessThan(String value) {
            addCriterion("xiuxijiany <", value, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyLessThanOrEqualTo(String value) {
            addCriterion("xiuxijiany <=", value, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyLike(String value) {
            addCriterion("xiuxijiany like", value, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyNotLike(String value) {
            addCriterion("xiuxijiany not like", value, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyIn(List<String> values) {
            addCriterion("xiuxijiany in", values, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyNotIn(List<String> values) {
            addCriterion("xiuxijiany not in", values, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyBetween(String value1, String value2) {
            addCriterion("xiuxijiany between", value1, value2, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andXiuxijianyNotBetween(String value1, String value2) {
            addCriterion("xiuxijiany not between", value1, value2, "xiuxijiany");
            return (Criteria) this;
        }

        public Criteria andYongyaoIsNull() {
            addCriterion("yongyao is null");
            return (Criteria) this;
        }

        public Criteria andYongyaoIsNotNull() {
            addCriterion("yongyao is not null");
            return (Criteria) this;
        }

        public Criteria andYongyaoEqualTo(String value) {
            addCriterion("yongyao =", value, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoNotEqualTo(String value) {
            addCriterion("yongyao <>", value, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoGreaterThan(String value) {
            addCriterion("yongyao >", value, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoGreaterThanOrEqualTo(String value) {
            addCriterion("yongyao >=", value, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoLessThan(String value) {
            addCriterion("yongyao <", value, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoLessThanOrEqualTo(String value) {
            addCriterion("yongyao <=", value, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoLike(String value) {
            addCriterion("yongyao like", value, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoNotLike(String value) {
            addCriterion("yongyao not like", value, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoIn(List<String> values) {
            addCriterion("yongyao in", values, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoNotIn(List<String> values) {
            addCriterion("yongyao not in", values, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoBetween(String value1, String value2) {
            addCriterion("yongyao between", value1, value2, "yongyao");
            return (Criteria) this;
        }

        public Criteria andYongyaoNotBetween(String value1, String value2) {
            addCriterion("yongyao not between", value1, value2, "yongyao");
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
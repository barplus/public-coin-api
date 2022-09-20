package com.coin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TContestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TContestExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andContestTypeIsNull() {
            addCriterion("contest_type is null");
            return (Criteria) this;
        }

        public Criteria andContestTypeIsNotNull() {
            addCriterion("contest_type is not null");
            return (Criteria) this;
        }

        public Criteria andContestTypeEqualTo(String value) {
            addCriterion("contest_type =", value, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeNotEqualTo(String value) {
            addCriterion("contest_type <>", value, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeGreaterThan(String value) {
            addCriterion("contest_type >", value, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("contest_type >=", value, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeLessThan(String value) {
            addCriterion("contest_type <", value, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeLessThanOrEqualTo(String value) {
            addCriterion("contest_type <=", value, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeLike(String value) {
            addCriterion("contest_type like", value, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeNotLike(String value) {
            addCriterion("contest_type not like", value, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeIn(List<String> values) {
            addCriterion("contest_type in", values, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeNotIn(List<String> values) {
            addCriterion("contest_type not in", values, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeBetween(String value1, String value2) {
            addCriterion("contest_type between", value1, value2, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestTypeNotBetween(String value1, String value2) {
            addCriterion("contest_type not between", value1, value2, "contestType");
            return (Criteria) this;
        }

        public Criteria andContestNameIsNull() {
            addCriterion("contest_name is null");
            return (Criteria) this;
        }

        public Criteria andContestNameIsNotNull() {
            addCriterion("contest_name is not null");
            return (Criteria) this;
        }

        public Criteria andContestNameEqualTo(String value) {
            addCriterion("contest_name =", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameNotEqualTo(String value) {
            addCriterion("contest_name <>", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameGreaterThan(String value) {
            addCriterion("contest_name >", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameGreaterThanOrEqualTo(String value) {
            addCriterion("contest_name >=", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameLessThan(String value) {
            addCriterion("contest_name <", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameLessThanOrEqualTo(String value) {
            addCriterion("contest_name <=", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameLike(String value) {
            addCriterion("contest_name like", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameNotLike(String value) {
            addCriterion("contest_name not like", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameIn(List<String> values) {
            addCriterion("contest_name in", values, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameNotIn(List<String> values) {
            addCriterion("contest_name not in", values, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameBetween(String value1, String value2) {
            addCriterion("contest_name between", value1, value2, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameNotBetween(String value1, String value2) {
            addCriterion("contest_name not between", value1, value2, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestDateIsNull() {
            addCriterion("contest_date is null");
            return (Criteria) this;
        }

        public Criteria andContestDateIsNotNull() {
            addCriterion("contest_date is not null");
            return (Criteria) this;
        }

        public Criteria andContestDateEqualTo(Date value) {
            addCriterion("contest_date =", value, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateNotEqualTo(Date value) {
            addCriterion("contest_date <>", value, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateGreaterThan(Date value) {
            addCriterion("contest_date >", value, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateGreaterThanOrEqualTo(Date value) {
            addCriterion("contest_date >=", value, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateLessThan(Date value) {
            addCriterion("contest_date <", value, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateLessThanOrEqualTo(Date value) {
            addCriterion("contest_date <=", value, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateIn(List<Date> values) {
            addCriterion("contest_date in", values, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateNotIn(List<Date> values) {
            addCriterion("contest_date not in", values, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateBetween(Date value1, Date value2) {
            addCriterion("contest_date between", value1, value2, "contestDate");
            return (Criteria) this;
        }

        public Criteria andContestDateNotBetween(Date value1, Date value2) {
            addCriterion("contest_date not between", value1, value2, "contestDate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstIsNull() {
            addCriterion("team_first is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstIsNotNull() {
            addCriterion("team_first is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstEqualTo(String value) {
            addCriterion("team_first =", value, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstNotEqualTo(String value) {
            addCriterion("team_first <>", value, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstGreaterThan(String value) {
            addCriterion("team_first >", value, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstGreaterThanOrEqualTo(String value) {
            addCriterion("team_first >=", value, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstLessThan(String value) {
            addCriterion("team_first <", value, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstLessThanOrEqualTo(String value) {
            addCriterion("team_first <=", value, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstLike(String value) {
            addCriterion("team_first like", value, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstNotLike(String value) {
            addCriterion("team_first not like", value, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstIn(List<String> values) {
            addCriterion("team_first in", values, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstNotIn(List<String> values) {
            addCriterion("team_first not in", values, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBetween(String value1, String value2) {
            addCriterion("team_first between", value1, value2, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstNotBetween(String value1, String value2) {
            addCriterion("team_first not between", value1, value2, "teamFirst");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicIsNull() {
            addCriterion("team_first_pic is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicIsNotNull() {
            addCriterion("team_first_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicEqualTo(String value) {
            addCriterion("team_first_pic =", value, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicNotEqualTo(String value) {
            addCriterion("team_first_pic <>", value, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicGreaterThan(String value) {
            addCriterion("team_first_pic >", value, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicGreaterThanOrEqualTo(String value) {
            addCriterion("team_first_pic >=", value, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicLessThan(String value) {
            addCriterion("team_first_pic <", value, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicLessThanOrEqualTo(String value) {
            addCriterion("team_first_pic <=", value, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicLike(String value) {
            addCriterion("team_first_pic like", value, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicNotLike(String value) {
            addCriterion("team_first_pic not like", value, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicIn(List<String> values) {
            addCriterion("team_first_pic in", values, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicNotIn(List<String> values) {
            addCriterion("team_first_pic not in", values, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicBetween(String value1, String value2) {
            addCriterion("team_first_pic between", value1, value2, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamFirstPicNotBetween(String value1, String value2) {
            addCriterion("team_first_pic not between", value1, value2, "teamFirstPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondIsNull() {
            addCriterion("team_second is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondIsNotNull() {
            addCriterion("team_second is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondEqualTo(String value) {
            addCriterion("team_second =", value, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondNotEqualTo(String value) {
            addCriterion("team_second <>", value, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondGreaterThan(String value) {
            addCriterion("team_second >", value, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondGreaterThanOrEqualTo(String value) {
            addCriterion("team_second >=", value, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondLessThan(String value) {
            addCriterion("team_second <", value, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondLessThanOrEqualTo(String value) {
            addCriterion("team_second <=", value, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondLike(String value) {
            addCriterion("team_second like", value, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondNotLike(String value) {
            addCriterion("team_second not like", value, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondIn(List<String> values) {
            addCriterion("team_second in", values, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondNotIn(List<String> values) {
            addCriterion("team_second not in", values, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBetween(String value1, String value2) {
            addCriterion("team_second between", value1, value2, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondNotBetween(String value1, String value2) {
            addCriterion("team_second not between", value1, value2, "teamSecond");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicIsNull() {
            addCriterion("team_second_pic is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicIsNotNull() {
            addCriterion("team_second_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicEqualTo(String value) {
            addCriterion("team_second_pic =", value, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicNotEqualTo(String value) {
            addCriterion("team_second_pic <>", value, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicGreaterThan(String value) {
            addCriterion("team_second_pic >", value, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicGreaterThanOrEqualTo(String value) {
            addCriterion("team_second_pic >=", value, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicLessThan(String value) {
            addCriterion("team_second_pic <", value, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicLessThanOrEqualTo(String value) {
            addCriterion("team_second_pic <=", value, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicLike(String value) {
            addCriterion("team_second_pic like", value, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicNotLike(String value) {
            addCriterion("team_second_pic not like", value, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicIn(List<String> values) {
            addCriterion("team_second_pic in", values, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicNotIn(List<String> values) {
            addCriterion("team_second_pic not in", values, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicBetween(String value1, String value2) {
            addCriterion("team_second_pic between", value1, value2, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andTeamSecondPicNotBetween(String value1, String value2) {
            addCriterion("team_second_pic not between", value1, value2, "teamSecondPic");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(Integer value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(Integer value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(Integer value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(Integer value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(Integer value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<Integer> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<Integer> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNull() {
            addCriterion("is_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNotNull() {
            addCriterion("is_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendEqualTo(Integer value) {
            addCriterion("is_recommend =", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotEqualTo(Integer value) {
            addCriterion("is_recommend <>", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThan(Integer value) {
            addCriterion("is_recommend >", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_recommend >=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThan(Integer value) {
            addCriterion("is_recommend <", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThanOrEqualTo(Integer value) {
            addCriterion("is_recommend <=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIn(List<Integer> values) {
            addCriterion("is_recommend in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotIn(List<Integer> values) {
            addCriterion("is_recommend not in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendBetween(Integer value1, Integer value2) {
            addCriterion("is_recommend between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotBetween(Integer value1, Integer value2) {
            addCriterion("is_recommend not between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreIsNull() {
            addCriterion("team_first_score is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreIsNotNull() {
            addCriterion("team_first_score is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreEqualTo(Integer value) {
            addCriterion("team_first_score =", value, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreNotEqualTo(Integer value) {
            addCriterion("team_first_score <>", value, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreGreaterThan(Integer value) {
            addCriterion("team_first_score >", value, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_first_score >=", value, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreLessThan(Integer value) {
            addCriterion("team_first_score <", value, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreLessThanOrEqualTo(Integer value) {
            addCriterion("team_first_score <=", value, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreIn(List<Integer> values) {
            addCriterion("team_first_score in", values, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreNotIn(List<Integer> values) {
            addCriterion("team_first_score not in", values, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreBetween(Integer value1, Integer value2) {
            addCriterion("team_first_score between", value1, value2, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamFirstScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("team_first_score not between", value1, value2, "teamFirstScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreIsNull() {
            addCriterion("team_second_score is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreIsNotNull() {
            addCriterion("team_second_score is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreEqualTo(Integer value) {
            addCriterion("team_second_score =", value, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreNotEqualTo(Integer value) {
            addCriterion("team_second_score <>", value, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreGreaterThan(Integer value) {
            addCriterion("team_second_score >", value, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_second_score >=", value, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreLessThan(Integer value) {
            addCriterion("team_second_score <", value, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreLessThanOrEqualTo(Integer value) {
            addCriterion("team_second_score <=", value, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreIn(List<Integer> values) {
            addCriterion("team_second_score in", values, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreNotIn(List<Integer> values) {
            addCriterion("team_second_score not in", values, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreBetween(Integer value1, Integer value2) {
            addCriterion("team_second_score between", value1, value2, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andTeamSecondScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("team_second_score not between", value1, value2, "teamSecondScore");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNull() {
            addCriterion("is_publish is null");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNotNull() {
            addCriterion("is_publish is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublishEqualTo(Integer value) {
            addCriterion("is_publish =", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotEqualTo(Integer value) {
            addCriterion("is_publish <>", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThan(Integer value) {
            addCriterion("is_publish >", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_publish >=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThan(Integer value) {
            addCriterion("is_publish <", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThanOrEqualTo(Integer value) {
            addCriterion("is_publish <=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishIn(List<Integer> values) {
            addCriterion("is_publish in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotIn(List<Integer> values) {
            addCriterion("is_publish not in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishBetween(Integer value1, Integer value2) {
            addCriterion("is_publish between", value1, value2, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotBetween(Integer value1, Integer value2) {
            addCriterion("is_publish not between", value1, value2, "isPublish");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterion("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterion("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterion("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterion("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterion("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterion("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterion("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterion("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterion("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andShowDateStartIsNull() {
            addCriterion("show_date_start is null");
            return (Criteria) this;
        }

        public Criteria andShowDateStartIsNotNull() {
            addCriterion("show_date_start is not null");
            return (Criteria) this;
        }

        public Criteria andShowDateStartEqualTo(Date value) {
            addCriterion("show_date_start =", value, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartNotEqualTo(Date value) {
            addCriterion("show_date_start <>", value, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartGreaterThan(Date value) {
            addCriterion("show_date_start >", value, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartGreaterThanOrEqualTo(Date value) {
            addCriterion("show_date_start >=", value, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartLessThan(Date value) {
            addCriterion("show_date_start <", value, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartLessThanOrEqualTo(Date value) {
            addCriterion("show_date_start <=", value, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartIn(List<Date> values) {
            addCriterion("show_date_start in", values, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartNotIn(List<Date> values) {
            addCriterion("show_date_start not in", values, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartBetween(Date value1, Date value2) {
            addCriterion("show_date_start between", value1, value2, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateStartNotBetween(Date value1, Date value2) {
            addCriterion("show_date_start not between", value1, value2, "showDateStart");
            return (Criteria) this;
        }

        public Criteria andShowDateEndIsNull() {
            addCriterion("show_date_end is null");
            return (Criteria) this;
        }

        public Criteria andShowDateEndIsNotNull() {
            addCriterion("show_date_end is not null");
            return (Criteria) this;
        }

        public Criteria andShowDateEndEqualTo(Date value) {
            addCriterion("show_date_end =", value, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndNotEqualTo(Date value) {
            addCriterion("show_date_end <>", value, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndGreaterThan(Date value) {
            addCriterion("show_date_end >", value, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndGreaterThanOrEqualTo(Date value) {
            addCriterion("show_date_end >=", value, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndLessThan(Date value) {
            addCriterion("show_date_end <", value, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndLessThanOrEqualTo(Date value) {
            addCriterion("show_date_end <=", value, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndIn(List<Date> values) {
            addCriterion("show_date_end in", values, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndNotIn(List<Date> values) {
            addCriterion("show_date_end not in", values, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndBetween(Date value1, Date value2) {
            addCriterion("show_date_end between", value1, value2, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andShowDateEndNotBetween(Date value1, Date value2) {
            addCriterion("show_date_end not between", value1, value2, "showDateEnd");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSortNumIsNull() {
            addCriterion("sort_num is null");
            return (Criteria) this;
        }

        public Criteria andSortNumIsNotNull() {
            addCriterion("sort_num is not null");
            return (Criteria) this;
        }

        public Criteria andSortNumEqualTo(Integer value) {
            addCriterion("sort_num =", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumNotEqualTo(Integer value) {
            addCriterion("sort_num <>", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumGreaterThan(Integer value) {
            addCriterion("sort_num >", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_num >=", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumLessThan(Integer value) {
            addCriterion("sort_num <", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumLessThanOrEqualTo(Integer value) {
            addCriterion("sort_num <=", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumIn(List<Integer> values) {
            addCriterion("sort_num in", values, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumNotIn(List<Integer> values) {
            addCriterion("sort_num not in", values, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumBetween(Integer value1, Integer value2) {
            addCriterion("sort_num between", value1, value2, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_num not between", value1, value2, "sortNum");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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
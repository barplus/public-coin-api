package com.coin.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TContestDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TContestDetailExample() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumIsNull() {
            addCriterion("team_first_win_num is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumIsNotNull() {
            addCriterion("team_first_win_num is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumEqualTo(Integer value) {
            addCriterion("team_first_win_num =", value, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumNotEqualTo(Integer value) {
            addCriterion("team_first_win_num <>", value, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumGreaterThan(Integer value) {
            addCriterion("team_first_win_num >", value, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_first_win_num >=", value, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumLessThan(Integer value) {
            addCriterion("team_first_win_num <", value, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumLessThanOrEqualTo(Integer value) {
            addCriterion("team_first_win_num <=", value, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumIn(List<Integer> values) {
            addCriterion("team_first_win_num in", values, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumNotIn(List<Integer> values) {
            addCriterion("team_first_win_num not in", values, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumBetween(Integer value1, Integer value2) {
            addCriterion("team_first_win_num between", value1, value2, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinNumNotBetween(Integer value1, Integer value2) {
            addCriterion("team_first_win_num not between", value1, value2, "teamFirstWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateIsNull() {
            addCriterion("team_first_win_rate is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateIsNotNull() {
            addCriterion("team_first_win_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateEqualTo(BigDecimal value) {
            addCriterion("team_first_win_rate =", value, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateNotEqualTo(BigDecimal value) {
            addCriterion("team_first_win_rate <>", value, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateGreaterThan(BigDecimal value) {
            addCriterion("team_first_win_rate >", value, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("team_first_win_rate >=", value, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateLessThan(BigDecimal value) {
            addCriterion("team_first_win_rate <", value, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("team_first_win_rate <=", value, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateIn(List<BigDecimal> values) {
            addCriterion("team_first_win_rate in", values, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateNotIn(List<BigDecimal> values) {
            addCriterion("team_first_win_rate not in", values, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_first_win_rate between", value1, value2, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_first_win_rate not between", value1, value2, "teamFirstWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumIsNull() {
            addCriterion("team_first_avg_num is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumIsNotNull() {
            addCriterion("team_first_avg_num is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumEqualTo(BigDecimal value) {
            addCriterion("team_first_avg_num =", value, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumNotEqualTo(BigDecimal value) {
            addCriterion("team_first_avg_num <>", value, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumGreaterThan(BigDecimal value) {
            addCriterion("team_first_avg_num >", value, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("team_first_avg_num >=", value, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumLessThan(BigDecimal value) {
            addCriterion("team_first_avg_num <", value, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("team_first_avg_num <=", value, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumIn(List<BigDecimal> values) {
            addCriterion("team_first_avg_num in", values, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumNotIn(List<BigDecimal> values) {
            addCriterion("team_first_avg_num not in", values, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_first_avg_num between", value1, value2, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_first_avg_num not between", value1, value2, "teamFirstAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumIsNull() {
            addCriterion("team_first_avg_loss_num is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumIsNotNull() {
            addCriterion("team_first_avg_loss_num is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumEqualTo(BigDecimal value) {
            addCriterion("team_first_avg_loss_num =", value, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumNotEqualTo(BigDecimal value) {
            addCriterion("team_first_avg_loss_num <>", value, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumGreaterThan(BigDecimal value) {
            addCriterion("team_first_avg_loss_num >", value, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("team_first_avg_loss_num >=", value, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumLessThan(BigDecimal value) {
            addCriterion("team_first_avg_loss_num <", value, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("team_first_avg_loss_num <=", value, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumIn(List<BigDecimal> values) {
            addCriterion("team_first_avg_loss_num in", values, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumNotIn(List<BigDecimal> values) {
            addCriterion("team_first_avg_loss_num not in", values, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_first_avg_loss_num between", value1, value2, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstAvgLossNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_first_avg_loss_num not between", value1, value2, "teamFirstAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsIsNull() {
            addCriterion("team_first_win_odds is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsIsNotNull() {
            addCriterion("team_first_win_odds is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsEqualTo(BigDecimal value) {
            addCriterion("team_first_win_odds =", value, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsNotEqualTo(BigDecimal value) {
            addCriterion("team_first_win_odds <>", value, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsGreaterThan(BigDecimal value) {
            addCriterion("team_first_win_odds >", value, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("team_first_win_odds >=", value, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsLessThan(BigDecimal value) {
            addCriterion("team_first_win_odds <", value, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("team_first_win_odds <=", value, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsIn(List<BigDecimal> values) {
            addCriterion("team_first_win_odds in", values, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsNotIn(List<BigDecimal> values) {
            addCriterion("team_first_win_odds not in", values, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_first_win_odds between", value1, value2, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstWinOddsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_first_win_odds not between", value1, value2, "teamFirstWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsIsNull() {
            addCriterion("team_first_concede_odds is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsIsNotNull() {
            addCriterion("team_first_concede_odds is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsEqualTo(String value) {
            addCriterion("team_first_concede_odds =", value, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsNotEqualTo(String value) {
            addCriterion("team_first_concede_odds <>", value, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsGreaterThan(String value) {
            addCriterion("team_first_concede_odds >", value, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsGreaterThanOrEqualTo(String value) {
            addCriterion("team_first_concede_odds >=", value, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsLessThan(String value) {
            addCriterion("team_first_concede_odds <", value, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsLessThanOrEqualTo(String value) {
            addCriterion("team_first_concede_odds <=", value, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsLike(String value) {
            addCriterion("team_first_concede_odds like", value, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsNotLike(String value) {
            addCriterion("team_first_concede_odds not like", value, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsIn(List<String> values) {
            addCriterion("team_first_concede_odds in", values, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsNotIn(List<String> values) {
            addCriterion("team_first_concede_odds not in", values, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsBetween(String value1, String value2) {
            addCriterion("team_first_concede_odds between", value1, value2, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstConcedeOddsNotBetween(String value1, String value2) {
            addCriterion("team_first_concede_odds not between", value1, value2, "teamFirstConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsIsNull() {
            addCriterion("team_first_big_small_odds is null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsIsNotNull() {
            addCriterion("team_first_big_small_odds is not null");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsEqualTo(String value) {
            addCriterion("team_first_big_small_odds =", value, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsNotEqualTo(String value) {
            addCriterion("team_first_big_small_odds <>", value, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsGreaterThan(String value) {
            addCriterion("team_first_big_small_odds >", value, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsGreaterThanOrEqualTo(String value) {
            addCriterion("team_first_big_small_odds >=", value, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsLessThan(String value) {
            addCriterion("team_first_big_small_odds <", value, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsLessThanOrEqualTo(String value) {
            addCriterion("team_first_big_small_odds <=", value, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsLike(String value) {
            addCriterion("team_first_big_small_odds like", value, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsNotLike(String value) {
            addCriterion("team_first_big_small_odds not like", value, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsIn(List<String> values) {
            addCriterion("team_first_big_small_odds in", values, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsNotIn(List<String> values) {
            addCriterion("team_first_big_small_odds not in", values, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsBetween(String value1, String value2) {
            addCriterion("team_first_big_small_odds between", value1, value2, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamFirstBigSmallOddsNotBetween(String value1, String value2) {
            addCriterion("team_first_big_small_odds not between", value1, value2, "teamFirstBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumIsNull() {
            addCriterion("team_second_win_num is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumIsNotNull() {
            addCriterion("team_second_win_num is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumEqualTo(Integer value) {
            addCriterion("team_second_win_num =", value, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumNotEqualTo(Integer value) {
            addCriterion("team_second_win_num <>", value, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumGreaterThan(Integer value) {
            addCriterion("team_second_win_num >", value, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_second_win_num >=", value, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumLessThan(Integer value) {
            addCriterion("team_second_win_num <", value, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumLessThanOrEqualTo(Integer value) {
            addCriterion("team_second_win_num <=", value, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumIn(List<Integer> values) {
            addCriterion("team_second_win_num in", values, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumNotIn(List<Integer> values) {
            addCriterion("team_second_win_num not in", values, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumBetween(Integer value1, Integer value2) {
            addCriterion("team_second_win_num between", value1, value2, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinNumNotBetween(Integer value1, Integer value2) {
            addCriterion("team_second_win_num not between", value1, value2, "teamSecondWinNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateIsNull() {
            addCriterion("team_second_win_rate is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateIsNotNull() {
            addCriterion("team_second_win_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateEqualTo(BigDecimal value) {
            addCriterion("team_second_win_rate =", value, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateNotEqualTo(BigDecimal value) {
            addCriterion("team_second_win_rate <>", value, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateGreaterThan(BigDecimal value) {
            addCriterion("team_second_win_rate >", value, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("team_second_win_rate >=", value, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateLessThan(BigDecimal value) {
            addCriterion("team_second_win_rate <", value, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("team_second_win_rate <=", value, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateIn(List<BigDecimal> values) {
            addCriterion("team_second_win_rate in", values, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateNotIn(List<BigDecimal> values) {
            addCriterion("team_second_win_rate not in", values, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_second_win_rate between", value1, value2, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_second_win_rate not between", value1, value2, "teamSecondWinRate");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumIsNull() {
            addCriterion("team_second_avg_num is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumIsNotNull() {
            addCriterion("team_second_avg_num is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumEqualTo(BigDecimal value) {
            addCriterion("team_second_avg_num =", value, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumNotEqualTo(BigDecimal value) {
            addCriterion("team_second_avg_num <>", value, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumGreaterThan(BigDecimal value) {
            addCriterion("team_second_avg_num >", value, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("team_second_avg_num >=", value, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumLessThan(BigDecimal value) {
            addCriterion("team_second_avg_num <", value, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("team_second_avg_num <=", value, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumIn(List<BigDecimal> values) {
            addCriterion("team_second_avg_num in", values, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumNotIn(List<BigDecimal> values) {
            addCriterion("team_second_avg_num not in", values, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_second_avg_num between", value1, value2, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_second_avg_num not between", value1, value2, "teamSecondAvgNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumIsNull() {
            addCriterion("team_second_avg_loss_num is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumIsNotNull() {
            addCriterion("team_second_avg_loss_num is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumEqualTo(BigDecimal value) {
            addCriterion("team_second_avg_loss_num =", value, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumNotEqualTo(BigDecimal value) {
            addCriterion("team_second_avg_loss_num <>", value, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumGreaterThan(BigDecimal value) {
            addCriterion("team_second_avg_loss_num >", value, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("team_second_avg_loss_num >=", value, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumLessThan(BigDecimal value) {
            addCriterion("team_second_avg_loss_num <", value, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("team_second_avg_loss_num <=", value, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumIn(List<BigDecimal> values) {
            addCriterion("team_second_avg_loss_num in", values, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumNotIn(List<BigDecimal> values) {
            addCriterion("team_second_avg_loss_num not in", values, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_second_avg_loss_num between", value1, value2, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondAvgLossNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_second_avg_loss_num not between", value1, value2, "teamSecondAvgLossNum");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsIsNull() {
            addCriterion("team_second_win_odds is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsIsNotNull() {
            addCriterion("team_second_win_odds is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsEqualTo(BigDecimal value) {
            addCriterion("team_second_win_odds =", value, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsNotEqualTo(BigDecimal value) {
            addCriterion("team_second_win_odds <>", value, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsGreaterThan(BigDecimal value) {
            addCriterion("team_second_win_odds >", value, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("team_second_win_odds >=", value, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsLessThan(BigDecimal value) {
            addCriterion("team_second_win_odds <", value, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("team_second_win_odds <=", value, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsIn(List<BigDecimal> values) {
            addCriterion("team_second_win_odds in", values, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsNotIn(List<BigDecimal> values) {
            addCriterion("team_second_win_odds not in", values, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_second_win_odds between", value1, value2, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondWinOddsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("team_second_win_odds not between", value1, value2, "teamSecondWinOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsIsNull() {
            addCriterion("team_second_concede_odds is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsIsNotNull() {
            addCriterion("team_second_concede_odds is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsEqualTo(String value) {
            addCriterion("team_second_concede_odds =", value, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsNotEqualTo(String value) {
            addCriterion("team_second_concede_odds <>", value, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsGreaterThan(String value) {
            addCriterion("team_second_concede_odds >", value, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsGreaterThanOrEqualTo(String value) {
            addCriterion("team_second_concede_odds >=", value, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsLessThan(String value) {
            addCriterion("team_second_concede_odds <", value, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsLessThanOrEqualTo(String value) {
            addCriterion("team_second_concede_odds <=", value, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsLike(String value) {
            addCriterion("team_second_concede_odds like", value, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsNotLike(String value) {
            addCriterion("team_second_concede_odds not like", value, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsIn(List<String> values) {
            addCriterion("team_second_concede_odds in", values, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsNotIn(List<String> values) {
            addCriterion("team_second_concede_odds not in", values, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsBetween(String value1, String value2) {
            addCriterion("team_second_concede_odds between", value1, value2, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondConcedeOddsNotBetween(String value1, String value2) {
            addCriterion("team_second_concede_odds not between", value1, value2, "teamSecondConcedeOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsIsNull() {
            addCriterion("team_second_big_small_odds is null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsIsNotNull() {
            addCriterion("team_second_big_small_odds is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsEqualTo(String value) {
            addCriterion("team_second_big_small_odds =", value, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsNotEqualTo(String value) {
            addCriterion("team_second_big_small_odds <>", value, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsGreaterThan(String value) {
            addCriterion("team_second_big_small_odds >", value, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsGreaterThanOrEqualTo(String value) {
            addCriterion("team_second_big_small_odds >=", value, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsLessThan(String value) {
            addCriterion("team_second_big_small_odds <", value, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsLessThanOrEqualTo(String value) {
            addCriterion("team_second_big_small_odds <=", value, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsLike(String value) {
            addCriterion("team_second_big_small_odds like", value, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsNotLike(String value) {
            addCriterion("team_second_big_small_odds not like", value, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsIn(List<String> values) {
            addCriterion("team_second_big_small_odds in", values, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsNotIn(List<String> values) {
            addCriterion("team_second_big_small_odds not in", values, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsBetween(String value1, String value2) {
            addCriterion("team_second_big_small_odds between", value1, value2, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andTeamSecondBigSmallOddsNotBetween(String value1, String value2) {
            addCriterion("team_second_big_small_odds not between", value1, value2, "teamSecondBigSmallOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsIsNull() {
            addCriterion("recommend_odds is null");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsIsNotNull() {
            addCriterion("recommend_odds is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsEqualTo(String value) {
            addCriterion("recommend_odds =", value, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsNotEqualTo(String value) {
            addCriterion("recommend_odds <>", value, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsGreaterThan(String value) {
            addCriterion("recommend_odds >", value, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_odds >=", value, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsLessThan(String value) {
            addCriterion("recommend_odds <", value, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsLessThanOrEqualTo(String value) {
            addCriterion("recommend_odds <=", value, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsLike(String value) {
            addCriterion("recommend_odds like", value, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsNotLike(String value) {
            addCriterion("recommend_odds not like", value, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsIn(List<String> values) {
            addCriterion("recommend_odds in", values, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsNotIn(List<String> values) {
            addCriterion("recommend_odds not in", values, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsBetween(String value1, String value2) {
            addCriterion("recommend_odds between", value1, value2, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andRecommendOddsNotBetween(String value1, String value2) {
            addCriterion("recommend_odds not between", value1, value2, "recommendOdds");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisIsNull() {
            addCriterion("contest_analysis is null");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisIsNotNull() {
            addCriterion("contest_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisEqualTo(String value) {
            addCriterion("contest_analysis =", value, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisNotEqualTo(String value) {
            addCriterion("contest_analysis <>", value, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisGreaterThan(String value) {
            addCriterion("contest_analysis >", value, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("contest_analysis >=", value, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisLessThan(String value) {
            addCriterion("contest_analysis <", value, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisLessThanOrEqualTo(String value) {
            addCriterion("contest_analysis <=", value, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisLike(String value) {
            addCriterion("contest_analysis like", value, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisNotLike(String value) {
            addCriterion("contest_analysis not like", value, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisIn(List<String> values) {
            addCriterion("contest_analysis in", values, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisNotIn(List<String> values) {
            addCriterion("contest_analysis not in", values, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisBetween(String value1, String value2) {
            addCriterion("contest_analysis between", value1, value2, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andContestAnalysisNotBetween(String value1, String value2) {
            addCriterion("contest_analysis not between", value1, value2, "contestAnalysis");
            return (Criteria) this;
        }

        public Criteria andDrawOddsIsNull() {
            addCriterion("draw_odds is null");
            return (Criteria) this;
        }

        public Criteria andDrawOddsIsNotNull() {
            addCriterion("draw_odds is not null");
            return (Criteria) this;
        }

        public Criteria andDrawOddsEqualTo(BigDecimal value) {
            addCriterion("draw_odds =", value, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsNotEqualTo(BigDecimal value) {
            addCriterion("draw_odds <>", value, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsGreaterThan(BigDecimal value) {
            addCriterion("draw_odds >", value, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("draw_odds >=", value, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsLessThan(BigDecimal value) {
            addCriterion("draw_odds <", value, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("draw_odds <=", value, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsIn(List<BigDecimal> values) {
            addCriterion("draw_odds in", values, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsNotIn(List<BigDecimal> values) {
            addCriterion("draw_odds not in", values, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("draw_odds between", value1, value2, "drawOdds");
            return (Criteria) this;
        }

        public Criteria andDrawOddsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("draw_odds not between", value1, value2, "drawOdds");
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
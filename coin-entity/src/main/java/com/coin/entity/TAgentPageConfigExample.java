package com.coin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAgentPageConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAgentPageConfigExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andTelegramIsNull() {
            addCriterion("telegram is null");
            return (Criteria) this;
        }

        public Criteria andTelegramIsNotNull() {
            addCriterion("telegram is not null");
            return (Criteria) this;
        }

        public Criteria andTelegramEqualTo(String value) {
            addCriterion("telegram =", value, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramNotEqualTo(String value) {
            addCriterion("telegram <>", value, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramGreaterThan(String value) {
            addCriterion("telegram >", value, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramGreaterThanOrEqualTo(String value) {
            addCriterion("telegram >=", value, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramLessThan(String value) {
            addCriterion("telegram <", value, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramLessThanOrEqualTo(String value) {
            addCriterion("telegram <=", value, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramLike(String value) {
            addCriterion("telegram like", value, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramNotLike(String value) {
            addCriterion("telegram not like", value, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramIn(List<String> values) {
            addCriterion("telegram in", values, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramNotIn(List<String> values) {
            addCriterion("telegram not in", values, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramBetween(String value1, String value2) {
            addCriterion("telegram between", value1, value2, "telegram");
            return (Criteria) this;
        }

        public Criteria andTelegramNotBetween(String value1, String value2) {
            addCriterion("telegram not between", value1, value2, "telegram");
            return (Criteria) this;
        }

        public Criteria andFlygramIsNull() {
            addCriterion("flygram is null");
            return (Criteria) this;
        }

        public Criteria andFlygramIsNotNull() {
            addCriterion("flygram is not null");
            return (Criteria) this;
        }

        public Criteria andFlygramEqualTo(String value) {
            addCriterion("flygram =", value, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramNotEqualTo(String value) {
            addCriterion("flygram <>", value, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramGreaterThan(String value) {
            addCriterion("flygram >", value, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramGreaterThanOrEqualTo(String value) {
            addCriterion("flygram >=", value, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramLessThan(String value) {
            addCriterion("flygram <", value, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramLessThanOrEqualTo(String value) {
            addCriterion("flygram <=", value, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramLike(String value) {
            addCriterion("flygram like", value, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramNotLike(String value) {
            addCriterion("flygram not like", value, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramIn(List<String> values) {
            addCriterion("flygram in", values, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramNotIn(List<String> values) {
            addCriterion("flygram not in", values, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramBetween(String value1, String value2) {
            addCriterion("flygram between", value1, value2, "flygram");
            return (Criteria) this;
        }

        public Criteria andFlygramNotBetween(String value1, String value2) {
            addCriterion("flygram not between", value1, value2, "flygram");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andLetstalkIsNull() {
            addCriterion("letstalk is null");
            return (Criteria) this;
        }

        public Criteria andLetstalkIsNotNull() {
            addCriterion("letstalk is not null");
            return (Criteria) this;
        }

        public Criteria andLetstalkEqualTo(String value) {
            addCriterion("letstalk =", value, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkNotEqualTo(String value) {
            addCriterion("letstalk <>", value, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkGreaterThan(String value) {
            addCriterion("letstalk >", value, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkGreaterThanOrEqualTo(String value) {
            addCriterion("letstalk >=", value, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkLessThan(String value) {
            addCriterion("letstalk <", value, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkLessThanOrEqualTo(String value) {
            addCriterion("letstalk <=", value, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkLike(String value) {
            addCriterion("letstalk like", value, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkNotLike(String value) {
            addCriterion("letstalk not like", value, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkIn(List<String> values) {
            addCriterion("letstalk in", values, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkNotIn(List<String> values) {
            addCriterion("letstalk not in", values, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkBetween(String value1, String value2) {
            addCriterion("letstalk between", value1, value2, "letstalk");
            return (Criteria) this;
        }

        public Criteria andLetstalkNotBetween(String value1, String value2) {
            addCriterion("letstalk not between", value1, value2, "letstalk");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkIsNull() {
            addCriterion("agent_register_link is null");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkIsNotNull() {
            addCriterion("agent_register_link is not null");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkEqualTo(String value) {
            addCriterion("agent_register_link =", value, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkNotEqualTo(String value) {
            addCriterion("agent_register_link <>", value, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkGreaterThan(String value) {
            addCriterion("agent_register_link >", value, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkGreaterThanOrEqualTo(String value) {
            addCriterion("agent_register_link >=", value, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkLessThan(String value) {
            addCriterion("agent_register_link <", value, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkLessThanOrEqualTo(String value) {
            addCriterion("agent_register_link <=", value, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkLike(String value) {
            addCriterion("agent_register_link like", value, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkNotLike(String value) {
            addCriterion("agent_register_link not like", value, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkIn(List<String> values) {
            addCriterion("agent_register_link in", values, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkNotIn(List<String> values) {
            addCriterion("agent_register_link not in", values, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkBetween(String value1, String value2) {
            addCriterion("agent_register_link between", value1, value2, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andAgentRegisterLinkNotBetween(String value1, String value2) {
            addCriterion("agent_register_link not between", value1, value2, "agentRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkIsNull() {
            addCriterion("platform_register_link is null");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkIsNotNull() {
            addCriterion("platform_register_link is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkEqualTo(String value) {
            addCriterion("platform_register_link =", value, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkNotEqualTo(String value) {
            addCriterion("platform_register_link <>", value, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkGreaterThan(String value) {
            addCriterion("platform_register_link >", value, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkGreaterThanOrEqualTo(String value) {
            addCriterion("platform_register_link >=", value, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkLessThan(String value) {
            addCriterion("platform_register_link <", value, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkLessThanOrEqualTo(String value) {
            addCriterion("platform_register_link <=", value, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkLike(String value) {
            addCriterion("platform_register_link like", value, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkNotLike(String value) {
            addCriterion("platform_register_link not like", value, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkIn(List<String> values) {
            addCriterion("platform_register_link in", values, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkNotIn(List<String> values) {
            addCriterion("platform_register_link not in", values, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkBetween(String value1, String value2) {
            addCriterion("platform_register_link between", value1, value2, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andPlatformRegisterLinkNotBetween(String value1, String value2) {
            addCriterion("platform_register_link not between", value1, value2, "platformRegisterLink");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameIsNull() {
            addCriterion("activity_sys_name is null");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameIsNotNull() {
            addCriterion("activity_sys_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameEqualTo(String value) {
            addCriterion("activity_sys_name =", value, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameNotEqualTo(String value) {
            addCriterion("activity_sys_name <>", value, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameGreaterThan(String value) {
            addCriterion("activity_sys_name >", value, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_sys_name >=", value, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameLessThan(String value) {
            addCriterion("activity_sys_name <", value, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameLessThanOrEqualTo(String value) {
            addCriterion("activity_sys_name <=", value, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameLike(String value) {
            addCriterion("activity_sys_name like", value, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameNotLike(String value) {
            addCriterion("activity_sys_name not like", value, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameIn(List<String> values) {
            addCriterion("activity_sys_name in", values, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameNotIn(List<String> values) {
            addCriterion("activity_sys_name not in", values, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameBetween(String value1, String value2) {
            addCriterion("activity_sys_name between", value1, value2, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivitySysNameNotBetween(String value1, String value2) {
            addCriterion("activity_sys_name not between", value1, value2, "activitySysName");
            return (Criteria) this;
        }

        public Criteria andActivityLinkIsNull() {
            addCriterion("activity_link is null");
            return (Criteria) this;
        }

        public Criteria andActivityLinkIsNotNull() {
            addCriterion("activity_link is not null");
            return (Criteria) this;
        }

        public Criteria andActivityLinkEqualTo(String value) {
            addCriterion("activity_link =", value, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkNotEqualTo(String value) {
            addCriterion("activity_link <>", value, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkGreaterThan(String value) {
            addCriterion("activity_link >", value, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkGreaterThanOrEqualTo(String value) {
            addCriterion("activity_link >=", value, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkLessThan(String value) {
            addCriterion("activity_link <", value, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkLessThanOrEqualTo(String value) {
            addCriterion("activity_link <=", value, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkLike(String value) {
            addCriterion("activity_link like", value, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkNotLike(String value) {
            addCriterion("activity_link not like", value, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkIn(List<String> values) {
            addCriterion("activity_link in", values, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkNotIn(List<String> values) {
            addCriterion("activity_link not in", values, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkBetween(String value1, String value2) {
            addCriterion("activity_link between", value1, value2, "activityLink");
            return (Criteria) this;
        }

        public Criteria andActivityLinkNotBetween(String value1, String value2) {
            addCriterion("activity_link not between", value1, value2, "activityLink");
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
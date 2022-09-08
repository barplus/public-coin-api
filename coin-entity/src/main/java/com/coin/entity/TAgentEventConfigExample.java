package com.coin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAgentEventConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAgentEventConfigExample() {
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

        public Criteria andEventIndexIsNull() {
            addCriterion("event_index is null");
            return (Criteria) this;
        }

        public Criteria andEventIndexIsNotNull() {
            addCriterion("event_index is not null");
            return (Criteria) this;
        }

        public Criteria andEventIndexEqualTo(Integer value) {
            addCriterion("event_index =", value, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexNotEqualTo(Integer value) {
            addCriterion("event_index <>", value, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexGreaterThan(Integer value) {
            addCriterion("event_index >", value, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_index >=", value, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexLessThan(Integer value) {
            addCriterion("event_index <", value, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexLessThanOrEqualTo(Integer value) {
            addCriterion("event_index <=", value, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexIn(List<Integer> values) {
            addCriterion("event_index in", values, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexNotIn(List<Integer> values) {
            addCriterion("event_index not in", values, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexBetween(Integer value1, Integer value2) {
            addCriterion("event_index between", value1, value2, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("event_index not between", value1, value2, "eventIndex");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNull() {
            addCriterion("event_name is null");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNotNull() {
            addCriterion("event_name is not null");
            return (Criteria) this;
        }

        public Criteria andEventNameEqualTo(String value) {
            addCriterion("event_name =", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotEqualTo(String value) {
            addCriterion("event_name <>", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThan(String value) {
            addCriterion("event_name >", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThanOrEqualTo(String value) {
            addCriterion("event_name >=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThan(String value) {
            addCriterion("event_name <", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThanOrEqualTo(String value) {
            addCriterion("event_name <=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLike(String value) {
            addCriterion("event_name like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotLike(String value) {
            addCriterion("event_name not like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameIn(List<String> values) {
            addCriterion("event_name in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotIn(List<String> values) {
            addCriterion("event_name not in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameBetween(String value1, String value2) {
            addCriterion("event_name between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotBetween(String value1, String value2) {
            addCriterion("event_name not between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListIsNull() {
            addCriterion("html_pic_list is null");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListIsNotNull() {
            addCriterion("html_pic_list is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListEqualTo(String value) {
            addCriterion("html_pic_list =", value, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListNotEqualTo(String value) {
            addCriterion("html_pic_list <>", value, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListGreaterThan(String value) {
            addCriterion("html_pic_list >", value, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListGreaterThanOrEqualTo(String value) {
            addCriterion("html_pic_list >=", value, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListLessThan(String value) {
            addCriterion("html_pic_list <", value, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListLessThanOrEqualTo(String value) {
            addCriterion("html_pic_list <=", value, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListLike(String value) {
            addCriterion("html_pic_list like", value, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListNotLike(String value) {
            addCriterion("html_pic_list not like", value, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListIn(List<String> values) {
            addCriterion("html_pic_list in", values, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListNotIn(List<String> values) {
            addCriterion("html_pic_list not in", values, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListBetween(String value1, String value2) {
            addCriterion("html_pic_list between", value1, value2, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicListNotBetween(String value1, String value2) {
            addCriterion("html_pic_list not between", value1, value2, "htmlPicList");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailIsNull() {
            addCriterion("html_pic_detail is null");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailIsNotNull() {
            addCriterion("html_pic_detail is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailEqualTo(String value) {
            addCriterion("html_pic_detail =", value, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailNotEqualTo(String value) {
            addCriterion("html_pic_detail <>", value, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailGreaterThan(String value) {
            addCriterion("html_pic_detail >", value, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailGreaterThanOrEqualTo(String value) {
            addCriterion("html_pic_detail >=", value, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailLessThan(String value) {
            addCriterion("html_pic_detail <", value, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailLessThanOrEqualTo(String value) {
            addCriterion("html_pic_detail <=", value, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailLike(String value) {
            addCriterion("html_pic_detail like", value, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailNotLike(String value) {
            addCriterion("html_pic_detail not like", value, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailIn(List<String> values) {
            addCriterion("html_pic_detail in", values, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailNotIn(List<String> values) {
            addCriterion("html_pic_detail not in", values, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailBetween(String value1, String value2) {
            addCriterion("html_pic_detail between", value1, value2, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andHtmlPicDetailNotBetween(String value1, String value2) {
            addCriterion("html_pic_detail not between", value1, value2, "htmlPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicListIsNull() {
            addCriterion("pc_pic_list is null");
            return (Criteria) this;
        }

        public Criteria andPcPicListIsNotNull() {
            addCriterion("pc_pic_list is not null");
            return (Criteria) this;
        }

        public Criteria andPcPicListEqualTo(String value) {
            addCriterion("pc_pic_list =", value, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListNotEqualTo(String value) {
            addCriterion("pc_pic_list <>", value, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListGreaterThan(String value) {
            addCriterion("pc_pic_list >", value, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListGreaterThanOrEqualTo(String value) {
            addCriterion("pc_pic_list >=", value, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListLessThan(String value) {
            addCriterion("pc_pic_list <", value, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListLessThanOrEqualTo(String value) {
            addCriterion("pc_pic_list <=", value, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListLike(String value) {
            addCriterion("pc_pic_list like", value, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListNotLike(String value) {
            addCriterion("pc_pic_list not like", value, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListIn(List<String> values) {
            addCriterion("pc_pic_list in", values, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListNotIn(List<String> values) {
            addCriterion("pc_pic_list not in", values, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListBetween(String value1, String value2) {
            addCriterion("pc_pic_list between", value1, value2, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicListNotBetween(String value1, String value2) {
            addCriterion("pc_pic_list not between", value1, value2, "pcPicList");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailIsNull() {
            addCriterion("pc_pic_detail is null");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailIsNotNull() {
            addCriterion("pc_pic_detail is not null");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailEqualTo(String value) {
            addCriterion("pc_pic_detail =", value, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailNotEqualTo(String value) {
            addCriterion("pc_pic_detail <>", value, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailGreaterThan(String value) {
            addCriterion("pc_pic_detail >", value, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailGreaterThanOrEqualTo(String value) {
            addCriterion("pc_pic_detail >=", value, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailLessThan(String value) {
            addCriterion("pc_pic_detail <", value, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailLessThanOrEqualTo(String value) {
            addCriterion("pc_pic_detail <=", value, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailLike(String value) {
            addCriterion("pc_pic_detail like", value, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailNotLike(String value) {
            addCriterion("pc_pic_detail not like", value, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailIn(List<String> values) {
            addCriterion("pc_pic_detail in", values, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailNotIn(List<String> values) {
            addCriterion("pc_pic_detail not in", values, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailBetween(String value1, String value2) {
            addCriterion("pc_pic_detail between", value1, value2, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andPcPicDetailNotBetween(String value1, String value2) {
            addCriterion("pc_pic_detail not between", value1, value2, "pcPicDetail");
            return (Criteria) this;
        }

        public Criteria andEventDateIsNull() {
            addCriterion("event_date is null");
            return (Criteria) this;
        }

        public Criteria andEventDateIsNotNull() {
            addCriterion("event_date is not null");
            return (Criteria) this;
        }

        public Criteria andEventDateEqualTo(Date value) {
            addCriterion("event_date =", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotEqualTo(Date value) {
            addCriterion("event_date <>", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateGreaterThan(Date value) {
            addCriterion("event_date >", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateGreaterThanOrEqualTo(Date value) {
            addCriterion("event_date >=", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateLessThan(Date value) {
            addCriterion("event_date <", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateLessThanOrEqualTo(Date value) {
            addCriterion("event_date <=", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateIn(List<Date> values) {
            addCriterion("event_date in", values, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotIn(List<Date> values) {
            addCriterion("event_date not in", values, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateBetween(Date value1, Date value2) {
            addCriterion("event_date between", value1, value2, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotBetween(Date value1, Date value2) {
            addCriterion("event_date not between", value1, value2, "eventDate");
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
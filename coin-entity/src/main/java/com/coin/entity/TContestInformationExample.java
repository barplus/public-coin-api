package com.coin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TContestInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TContestInformationExample() {
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

        public Criteria andInformationTitleIsNull() {
            addCriterion("information_title is null");
            return (Criteria) this;
        }

        public Criteria andInformationTitleIsNotNull() {
            addCriterion("information_title is not null");
            return (Criteria) this;
        }

        public Criteria andInformationTitleEqualTo(String value) {
            addCriterion("information_title =", value, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleNotEqualTo(String value) {
            addCriterion("information_title <>", value, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleGreaterThan(String value) {
            addCriterion("information_title >", value, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleGreaterThanOrEqualTo(String value) {
            addCriterion("information_title >=", value, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleLessThan(String value) {
            addCriterion("information_title <", value, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleLessThanOrEqualTo(String value) {
            addCriterion("information_title <=", value, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleLike(String value) {
            addCriterion("information_title like", value, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleNotLike(String value) {
            addCriterion("information_title not like", value, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleIn(List<String> values) {
            addCriterion("information_title in", values, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleNotIn(List<String> values) {
            addCriterion("information_title not in", values, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleBetween(String value1, String value2) {
            addCriterion("information_title between", value1, value2, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationTitleNotBetween(String value1, String value2) {
            addCriterion("information_title not between", value1, value2, "informationTitle");
            return (Criteria) this;
        }

        public Criteria andInformationContentIsNull() {
            addCriterion("information_content is null");
            return (Criteria) this;
        }

        public Criteria andInformationContentIsNotNull() {
            addCriterion("information_content is not null");
            return (Criteria) this;
        }

        public Criteria andInformationContentEqualTo(String value) {
            addCriterion("information_content =", value, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentNotEqualTo(String value) {
            addCriterion("information_content <>", value, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentGreaterThan(String value) {
            addCriterion("information_content >", value, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentGreaterThanOrEqualTo(String value) {
            addCriterion("information_content >=", value, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentLessThan(String value) {
            addCriterion("information_content <", value, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentLessThanOrEqualTo(String value) {
            addCriterion("information_content <=", value, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentLike(String value) {
            addCriterion("information_content like", value, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentNotLike(String value) {
            addCriterion("information_content not like", value, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentIn(List<String> values) {
            addCriterion("information_content in", values, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentNotIn(List<String> values) {
            addCriterion("information_content not in", values, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentBetween(String value1, String value2) {
            addCriterion("information_content between", value1, value2, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationContentNotBetween(String value1, String value2) {
            addCriterion("information_content not between", value1, value2, "informationContent");
            return (Criteria) this;
        }

        public Criteria andInformationPicIsNull() {
            addCriterion("information_pic is null");
            return (Criteria) this;
        }

        public Criteria andInformationPicIsNotNull() {
            addCriterion("information_pic is not null");
            return (Criteria) this;
        }

        public Criteria andInformationPicEqualTo(String value) {
            addCriterion("information_pic =", value, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicNotEqualTo(String value) {
            addCriterion("information_pic <>", value, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicGreaterThan(String value) {
            addCriterion("information_pic >", value, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicGreaterThanOrEqualTo(String value) {
            addCriterion("information_pic >=", value, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicLessThan(String value) {
            addCriterion("information_pic <", value, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicLessThanOrEqualTo(String value) {
            addCriterion("information_pic <=", value, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicLike(String value) {
            addCriterion("information_pic like", value, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicNotLike(String value) {
            addCriterion("information_pic not like", value, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicIn(List<String> values) {
            addCriterion("information_pic in", values, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicNotIn(List<String> values) {
            addCriterion("information_pic not in", values, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicBetween(String value1, String value2) {
            addCriterion("information_pic between", value1, value2, "informationPic");
            return (Criteria) this;
        }

        public Criteria andInformationPicNotBetween(String value1, String value2) {
            addCriterion("information_pic not between", value1, value2, "informationPic");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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
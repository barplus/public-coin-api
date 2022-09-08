package com.coin.entity;

import java.io.Serializable;
import java.util.Date;

public class TAgentEventConfig implements Serializable {
    private Integer id;

    private Integer eventIndex;

    private String eventName;

    private String htmlPicList;

    private String htmlPicDetail;

    private String pcPicList;

    private String pcPicDetail;

    private Date eventDate;

    private Integer status;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private String eventContent;

    private String eventRule;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventIndex() {
        return eventIndex;
    }

    public void setEventIndex(Integer eventIndex) {
        this.eventIndex = eventIndex;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getHtmlPicList() {
        return htmlPicList;
    }

    public void setHtmlPicList(String htmlPicList) {
        this.htmlPicList = htmlPicList;
    }

    public String getHtmlPicDetail() {
        return htmlPicDetail;
    }

    public void setHtmlPicDetail(String htmlPicDetail) {
        this.htmlPicDetail = htmlPicDetail;
    }

    public String getPcPicList() {
        return pcPicList;
    }

    public void setPcPicList(String pcPicList) {
        this.pcPicList = pcPicList;
    }

    public String getPcPicDetail() {
        return pcPicDetail;
    }

    public void setPcPicDetail(String pcPicDetail) {
        this.pcPicDetail = pcPicDetail;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public String getEventRule() {
        return eventRule;
    }

    public void setEventRule(String eventRule) {
        this.eventRule = eventRule;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eventIndex=").append(eventIndex);
        sb.append(", eventName=").append(eventName);
        sb.append(", htmlPicList=").append(htmlPicList);
        sb.append(", htmlPicDetail=").append(htmlPicDetail);
        sb.append(", pcPicList=").append(pcPicList);
        sb.append(", pcPicDetail=").append(pcPicDetail);
        sb.append(", eventDate=").append(eventDate);
        sb.append(", status=").append(status);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", eventContent=").append(eventContent);
        sb.append(", eventRule=").append(eventRule);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
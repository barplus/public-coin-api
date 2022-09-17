package com.coin.entity;

import java.io.Serializable;
import java.util.Date;

public class TContestNotice implements Serializable {
    private Integer id;

    private String noticeTitle;

    private String noticeContent;

    private Integer isPublish;

    private Date publishDate;

    private Date showDateStart;

    private Date showDateEnd;

    private Integer isTop;

    private Date topDateStart;

    private Date topDateEnd;

    private Integer status;

    private Integer isDelete;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getShowDateStart() {
        return showDateStart;
    }

    public void setShowDateStart(Date showDateStart) {
        this.showDateStart = showDateStart;
    }

    public Date getShowDateEnd() {
        return showDateEnd;
    }

    public void setShowDateEnd(Date showDateEnd) {
        this.showDateEnd = showDateEnd;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Date getTopDateStart() {
        return topDateStart;
    }

    public void setTopDateStart(Date topDateStart) {
        this.topDateStart = topDateStart;
    }

    public Date getTopDateEnd() {
        return topDateEnd;
    }

    public void setTopDateEnd(Date topDateEnd) {
        this.topDateEnd = topDateEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", noticeContent=").append(noticeContent);
        sb.append(", isPublish=").append(isPublish);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", showDateStart=").append(showDateStart);
        sb.append(", showDateEnd=").append(showDateEnd);
        sb.append(", isTop=").append(isTop);
        sb.append(", topDateStart=").append(topDateStart);
        sb.append(", topDateEnd=").append(topDateEnd);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
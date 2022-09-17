package com.coin.entity;

import java.io.Serializable;
import java.util.Date;

public class TContest implements Serializable {
    private Integer id;

    private Integer parentId;

    private String contestType;

    private String contestName;

    private String contestSchedule;

    private Date contestDate;

    private String teamFirst;

    private String teamFirstPic;

    private String teamSecond;

    private String teamSecondPic;

    private Integer isHot;

    private Integer isRecommend;

    private String contestResult;

    private Integer contestPhase;

    private Integer isPublish;

    private Date publishDate;

    private Integer status;

    private Integer sortNum;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestSchedule() {
        return contestSchedule;
    }

    public void setContestSchedule(String contestSchedule) {
        this.contestSchedule = contestSchedule;
    }

    public Date getContestDate() {
        return contestDate;
    }

    public void setContestDate(Date contestDate) {
        this.contestDate = contestDate;
    }

    public String getTeamFirst() {
        return teamFirst;
    }

    public void setTeamFirst(String teamFirst) {
        this.teamFirst = teamFirst;
    }

    public String getTeamFirstPic() {
        return teamFirstPic;
    }

    public void setTeamFirstPic(String teamFirstPic) {
        this.teamFirstPic = teamFirstPic;
    }

    public String getTeamSecond() {
        return teamSecond;
    }

    public void setTeamSecond(String teamSecond) {
        this.teamSecond = teamSecond;
    }

    public String getTeamSecondPic() {
        return teamSecondPic;
    }

    public void setTeamSecondPic(String teamSecondPic) {
        this.teamSecondPic = teamSecondPic;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getContestResult() {
        return contestResult;
    }

    public void setContestResult(String contestResult) {
        this.contestResult = contestResult;
    }

    public Integer getContestPhase() {
        return contestPhase;
    }

    public void setContestPhase(Integer contestPhase) {
        this.contestPhase = contestPhase;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
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
        sb.append(", parentId=").append(parentId);
        sb.append(", contestType=").append(contestType);
        sb.append(", contestName=").append(contestName);
        sb.append(", contestSchedule=").append(contestSchedule);
        sb.append(", contestDate=").append(contestDate);
        sb.append(", teamFirst=").append(teamFirst);
        sb.append(", teamFirstPic=").append(teamFirstPic);
        sb.append(", teamSecond=").append(teamSecond);
        sb.append(", teamSecondPic=").append(teamSecondPic);
        sb.append(", isHot=").append(isHot);
        sb.append(", isRecommend=").append(isRecommend);
        sb.append(", contestResult=").append(contestResult);
        sb.append(", contestPhase=").append(contestPhase);
        sb.append(", isPublish=").append(isPublish);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", status=").append(status);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.coin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TContestDetail implements Serializable {
    private Integer id;

    private Integer pId;

    private Integer teamFirstWinNum;

    private BigDecimal teamFirstWinRate;

    private BigDecimal teamFirstAvgNum;

    private BigDecimal teamFirstAvgLossNum;

    private BigDecimal teamFirstWinOdds;

    private String teamFirstConcedeOdds;

    private String teamFirstBigSmallOdds;

    private Integer teamSecondWinNum;

    private BigDecimal teamSecondWinRate;

    private BigDecimal teamSecondAvgNum;

    private BigDecimal teamSecondAvgLossNum;

    private BigDecimal teamSecondWinOdds;

    private String teamSecondConcedeOdds;

    private String teamSecondBigSmallOdds;

    private String recommendOdds;

    private String contestAnalysis;

    private BigDecimal drawOdds;

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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getTeamFirstWinNum() {
        return teamFirstWinNum;
    }

    public void setTeamFirstWinNum(Integer teamFirstWinNum) {
        this.teamFirstWinNum = teamFirstWinNum;
    }

    public BigDecimal getTeamFirstWinRate() {
        return teamFirstWinRate;
    }

    public void setTeamFirstWinRate(BigDecimal teamFirstWinRate) {
        this.teamFirstWinRate = teamFirstWinRate;
    }

    public BigDecimal getTeamFirstAvgNum() {
        return teamFirstAvgNum;
    }

    public void setTeamFirstAvgNum(BigDecimal teamFirstAvgNum) {
        this.teamFirstAvgNum = teamFirstAvgNum;
    }

    public BigDecimal getTeamFirstAvgLossNum() {
        return teamFirstAvgLossNum;
    }

    public void setTeamFirstAvgLossNum(BigDecimal teamFirstAvgLossNum) {
        this.teamFirstAvgLossNum = teamFirstAvgLossNum;
    }

    public BigDecimal getTeamFirstWinOdds() {
        return teamFirstWinOdds;
    }

    public void setTeamFirstWinOdds(BigDecimal teamFirstWinOdds) {
        this.teamFirstWinOdds = teamFirstWinOdds;
    }

    public String getTeamFirstConcedeOdds() {
        return teamFirstConcedeOdds;
    }

    public void setTeamFirstConcedeOdds(String teamFirstConcedeOdds) {
        this.teamFirstConcedeOdds = teamFirstConcedeOdds;
    }

    public String getTeamFirstBigSmallOdds() {
        return teamFirstBigSmallOdds;
    }

    public void setTeamFirstBigSmallOdds(String teamFirstBigSmallOdds) {
        this.teamFirstBigSmallOdds = teamFirstBigSmallOdds;
    }

    public Integer getTeamSecondWinNum() {
        return teamSecondWinNum;
    }

    public void setTeamSecondWinNum(Integer teamSecondWinNum) {
        this.teamSecondWinNum = teamSecondWinNum;
    }

    public BigDecimal getTeamSecondWinRate() {
        return teamSecondWinRate;
    }

    public void setTeamSecondWinRate(BigDecimal teamSecondWinRate) {
        this.teamSecondWinRate = teamSecondWinRate;
    }

    public BigDecimal getTeamSecondAvgNum() {
        return teamSecondAvgNum;
    }

    public void setTeamSecondAvgNum(BigDecimal teamSecondAvgNum) {
        this.teamSecondAvgNum = teamSecondAvgNum;
    }

    public BigDecimal getTeamSecondAvgLossNum() {
        return teamSecondAvgLossNum;
    }

    public void setTeamSecondAvgLossNum(BigDecimal teamSecondAvgLossNum) {
        this.teamSecondAvgLossNum = teamSecondAvgLossNum;
    }

    public BigDecimal getTeamSecondWinOdds() {
        return teamSecondWinOdds;
    }

    public void setTeamSecondWinOdds(BigDecimal teamSecondWinOdds) {
        this.teamSecondWinOdds = teamSecondWinOdds;
    }

    public String getTeamSecondConcedeOdds() {
        return teamSecondConcedeOdds;
    }

    public void setTeamSecondConcedeOdds(String teamSecondConcedeOdds) {
        this.teamSecondConcedeOdds = teamSecondConcedeOdds;
    }

    public String getTeamSecondBigSmallOdds() {
        return teamSecondBigSmallOdds;
    }

    public void setTeamSecondBigSmallOdds(String teamSecondBigSmallOdds) {
        this.teamSecondBigSmallOdds = teamSecondBigSmallOdds;
    }

    public String getRecommendOdds() {
        return recommendOdds;
    }

    public void setRecommendOdds(String recommendOdds) {
        this.recommendOdds = recommendOdds;
    }

    public String getContestAnalysis() {
        return contestAnalysis;
    }

    public void setContestAnalysis(String contestAnalysis) {
        this.contestAnalysis = contestAnalysis;
    }

    public BigDecimal getDrawOdds() {
        return drawOdds;
    }

    public void setDrawOdds(BigDecimal drawOdds) {
        this.drawOdds = drawOdds;
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
        sb.append(", pId=").append(pId);
        sb.append(", teamFirstWinNum=").append(teamFirstWinNum);
        sb.append(", teamFirstWinRate=").append(teamFirstWinRate);
        sb.append(", teamFirstAvgNum=").append(teamFirstAvgNum);
        sb.append(", teamFirstAvgLossNum=").append(teamFirstAvgLossNum);
        sb.append(", teamFirstWinOdds=").append(teamFirstWinOdds);
        sb.append(", teamFirstConcedeOdds=").append(teamFirstConcedeOdds);
        sb.append(", teamFirstBigSmallOdds=").append(teamFirstBigSmallOdds);
        sb.append(", teamSecondWinNum=").append(teamSecondWinNum);
        sb.append(", teamSecondWinRate=").append(teamSecondWinRate);
        sb.append(", teamSecondAvgNum=").append(teamSecondAvgNum);
        sb.append(", teamSecondAvgLossNum=").append(teamSecondAvgLossNum);
        sb.append(", teamSecondWinOdds=").append(teamSecondWinOdds);
        sb.append(", teamSecondConcedeOdds=").append(teamSecondConcedeOdds);
        sb.append(", teamSecondBigSmallOdds=").append(teamSecondBigSmallOdds);
        sb.append(", recommendOdds=").append(recommendOdds);
        sb.append(", contestAnalysis=").append(contestAnalysis);
        sb.append(", drawOdds=").append(drawOdds);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
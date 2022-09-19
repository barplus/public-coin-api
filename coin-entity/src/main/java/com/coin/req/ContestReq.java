package com.coin.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 比赛请求对象
 */
@Data
@ToString(callSuper=true)
public class ContestReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String contestType;
    private String contestName;
    private Integer isHot;
    private Integer isRecommend;
    private Integer isPublish;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date contestDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date contestDateMin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date contestDateMax;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date showDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date showDateEnd;
    private String teamFirst;
    private String teamFirstPic;
    private String teamSecond;
    private String teamSecondPic;
    private Integer status;
    private Integer sortNum;

    private Integer teamFirstWinNum;
    private BigDecimal teamFirstWinRate;
    private BigDecimal teamFirstAvgNum;
    private BigDecimal teamFirstAvgLossNum;
    private BigDecimal teamFirstWinOdds;
    private String teamFirstConcedeOdds;
    private String teamFirstBigSmallOdds;
    private Integer teamSecondWinNum;
    private BigDecimal teamSecondAvgNum;
    private BigDecimal teamSecondWinRate;
    private BigDecimal teamSecondAvgLossNum;
    private BigDecimal teamSecondWinOdds;
    private String teamSecondConcedeOdds;
    private String teamSecondBigSmallOdds;
    private String recommendOdds;
    private String contestAnalysis;
    private BigDecimal drawOdds;

}

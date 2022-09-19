package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
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
    private Date contestDate;
    private Date contestDateMin;
    private Date contestDateMax;
    private String teamFirst;
    private String teamFirstPic;
    private String teamSecond;
    private String teamSecondPic;
    private Integer status;
    private Integer sortNum;

}

package com.coin.rsp;

import com.coin.entity.TContestDetail;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ContestRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String contestType;

    private String contestName;

    private Date contestDate;

    private String teamFirst;

    private String teamFirstPic;

    private String teamSecond;

    private String teamSecondPic;

    private Integer isHot;

    private Integer isRecommend;

    private Integer teamFirstScore;

    private Integer teamSecondScore;

    private Integer isPublish;

    private Date publishDate;

    private Date showDateStart;

    private Date showDateEnd;

    private Integer status;

    private Integer sortNum;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private TContestDetail contestDetail;

}
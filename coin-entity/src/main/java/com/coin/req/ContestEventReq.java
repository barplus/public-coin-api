package com.coin.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 比赛活动请求对象
 */
@Data
@ToString(callSuper=true)
public class ContestEventReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String eventTitle;

    private String eventTag;

    private String eventPic;

    private Integer isJump;

    private String jumpUrl;

    private Integer isPublish;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date showDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date showDateEnd;

    private Integer status;

    private Integer isDelete;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Date showDate;

}

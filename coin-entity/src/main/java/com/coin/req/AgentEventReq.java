package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 代理活动配置请求对象
 */
@Data
@ToString(callSuper=true)
public class AgentEventReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

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

    private String eventContent;

    private String eventRule;

}
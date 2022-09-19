package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 比赛赞助配置请求对象
 */
@Data
@ToString(callSuper=true)
public class ContestSponsorshipLogoReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;

    private Integer shortNum;

}

package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 赛事日报配置请求对象
 */
@Data
@ToString(callSuper=true)
public class ContestConfigReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**顶部LOGO链接地址*/
    private String topLogoLink;
    /**赞助LOGO链接地址*/
    private String sponsorshipLogoLink;
    /**品牌介绍*/
    private String brandExplain;
    /**注册链接*/
    private String registerLink;
    /**分享链接*/
    private String shareLink;

}

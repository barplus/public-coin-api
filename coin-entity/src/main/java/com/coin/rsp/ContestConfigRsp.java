package com.coin.rsp;

import com.coin.entity.TContestSponsorshipLogo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ContestConfigRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**顶部LOGO链接地址*/
    private String topLogoLink;
    /**赞助LOGO链接地址*/
    private String sponsorshipLogoLink;
    /**品牌介绍*/
    private String brandExplain;
    /**赞助配置列表*/
    private List<TContestSponsorshipLogo> contestSponsorshipLogos;

}
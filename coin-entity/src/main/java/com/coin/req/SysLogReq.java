package com.coin.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志请求对象
 */
@Data
@ToString(callSuper=true)
public class SysLogReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**会员账号*/
    private String queryLoginName;
    /**操作人*/
    private String createUser;
    /**日志类型:修改密码-1, 增加抽奖次数-2, 幸运大转盘签到-3 代理落地页配置变化-4、5、6、7*/
    private Integer logType;
    /**日志类型,多个用逗号分隔*/
    private String logTypes;
    /**最小操作时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date minDate;
    /**最大操作时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date maxDate;

}

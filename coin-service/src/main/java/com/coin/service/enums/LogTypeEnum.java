package com.coin.service.enums;

public enum LogTypeEnum {

    // 公共
    CLEAR_PASS(1, "清除密码"),
    ADD_LOTTERY_TIME(2,"增加抽奖次数"),
    EVERYDAY_SIGN(3,"幸运大转盘每日签到"),
    AGENT_CONFIG_BATCH_IMPORT(4,"代理招商活动配置批量导入日志"),
    AGENT_CONFIG_DELETE(5,"代理招商活动配置删除日志"),
    AGENT_CONFIG_ADD(6,"代理招商活动配置新增日志"),
    AGENT_CONFIG_UPDATE(7,"代理招商活动配置修改日志");

    public int code;
    public String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    LogTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMsgByCode(int code){
        for(LogTypeEnum logType:LogTypeEnum.values()){
            if(code == logType.getCode()){
                return logType.getMessage();
            }
        }
        return null;
    }

}

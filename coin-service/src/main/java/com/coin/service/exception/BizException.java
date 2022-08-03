package com.coin.service.exception;

public class BizException extends RuntimeException {

    private String code;

    private String errMsg;

    public  BizException(String errorCode, String errorMsg){
        this.code = errorCode;
        this.errMsg = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}

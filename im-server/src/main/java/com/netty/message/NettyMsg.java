package com.netty.message;

import java.io.Serializable;

public class NettyMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msgCode;
    private String msgType;
    private String msgTxt;
    private String msgFrom;
    private String msgTo;
    private Long sendDate;

    public NettyMsg(){}

    public NettyMsg(String msgCode, String msgType, String msgTxt, String msgFrom, String msgTo){
        this.msgCode = msgCode;
        this.msgType = msgType;
        this.msgTxt = msgTxt;
        this.msgFrom = msgFrom;
        this.msgTo = msgTo;
        this.sendDate = System.currentTimeMillis();
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgTxt() {
        return msgTxt;
    }

    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt;
    }

    public String getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(String msgFrom) {
        this.msgFrom = msgFrom;
    }

    public String getMsgTo() {
        return msgTo;
    }

    public void setMsgTo(String msgTo) {
        this.msgTo = msgTo;
    }

    public Long getSendDate() {
        return sendDate;
    }

    public void setSendDate(Long sendDate) {
        this.sendDate = sendDate;
    }
}

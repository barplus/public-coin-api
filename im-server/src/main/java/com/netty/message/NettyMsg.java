package com.netty.message;

import java.io.Serializable;

public class NettyMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msgCode;
    /**1-建立连接发送消息 2-普通文本消息 3-普通图片路径*/
    private String msgType;
    private String msgTxt;
    private String fromToken;
    private String fromChannelId;
    private String toToken;
    private String toChannelId;
    private Long sendDate;

    public NettyMsg(){}

    public NettyMsg(String msgCode, String msgType, String msgTxt, String fromToken, String fromChannelId, String toToken, String toChannelId){
        this.msgCode = msgCode;
        this.msgType = msgType;
        this.msgTxt = msgTxt;
        this.fromToken = fromToken;
        this.fromChannelId = fromChannelId;
        this.toToken = toToken;
        this.toChannelId = toChannelId;
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

    public String getFromToken() {
        return fromToken;
    }

    public void setFromToken(String fromToken) {
        this.fromToken = fromToken;
    }

    public String getFromChannelId() {
        return fromChannelId;
    }

    public void setFromChannelId(String fromChannelId) {
        this.fromChannelId = fromChannelId;
    }

    public String getToToken() {
        return toToken;
    }

    public void setToToken(String toToken) {
        this.toToken = toToken;
    }

    public String getToChannelId() {
        return toChannelId;
    }

    public void setToChannelId(String toChannelId) {
        this.toChannelId = toChannelId;
    }

    public Long getSendDate() {
        return sendDate;
    }

    public void setSendDate(Long sendDate) {
        this.sendDate = sendDate;
    }
}

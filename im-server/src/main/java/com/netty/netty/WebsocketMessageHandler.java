package com.netty.netty;

import com.alibaba.fastjson2.JSONObject;
import com.netty.message.NettyMsg;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//TextWebSocketFrame是netty用于处理websocket发来的文本对象
@Sharable
@Component
public class WebsocketMessageHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger logger = LoggerFactory.getLogger(WebsocketMessageHandler.class);

    //所有正在连接的channel都会存在这里面，所以也可以间接代表在线的客户端
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //在线人数
    public static int online;
    @Resource
    RedisTemplate redisTemplate;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        NettyMsg message = JSONObject.parseObject(msg.text(), NettyMsg.class);
        message.setMsgCode("0001");
        this.sendAllMessages(ctx, message);
        //        ctx.channel().writeAndFlush(new TextWebSocketFrame("我收到了你的消息：" + msg.text() + "" + System.currentTimeMillis()));
//        if (msg instanceof TextWebSocketFrame) {
//            TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) msg;
//            ctx.channel().writeAndFlush(new TextWebSocketFrame("我收到了你的消息：" + System.currentTimeMillis()));
//        } else {
//            // 不接受文本以外的数据帧类型
//            ctx.channel().writeAndFlush(WebSocketCloseStatus.INVALID_MESSAGE_TYPE).addListener(ChannelFutureListener.CLOSE);
//        }
    }

//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        super.channelInactive(ctx);
//        logger.info("netty-链接断开：{}", ctx.channel().remoteAddress());
//    }
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
//        logger.info("netty-链接创建：{}", ctx.channel().remoteAddress());
//    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
        online=channelGroup.size();
        logger.info("netty-链接创建：{}", ctx.channel().remoteAddress());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.remove(ctx.channel());
        online=channelGroup.size();
        logger.info("netty-链接断开：{}", ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("netty-发生异常：{}", cause);
    }

    /**
     * 发送单人消息
     * @param ctx
     * @param msg
     */
    private void sendMessage(ChannelHandlerContext ctx, NettyMsg msg) {
        ctx.channel().writeAndFlush(new TextWebSocketFrame(msg.getMsgTxt()));
    }

    /**
     * 发送群体消息
     * @param ctx
     * @param msg
     */
    private void sendAllMessages(ChannelHandlerContext ctx,NettyMsg msg) {
        for(Channel channel:channelGroup){
//            if(!channel.id().asLongText().equals(ctx.channel().id().asLongText())){
                channel.writeAndFlush(new TextWebSocketFrame(msg.getMsgTxt()));
//            }
        }
    }

    private void saveChannelInfoToRedis(String channelId, String token){
        Object info = redisTemplate.opsForValue().get(token);
        if(info == null){
            redisTemplate.opsForValue().set(token, channelId);
        }
    }

}
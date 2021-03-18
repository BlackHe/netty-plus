package io.netty.codec.demo.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.Instant;

public class SpCodecServerHandler extends SimpleChannelInboundHandler<Long> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("服务端接受到消息："+msg);
        //服务端写Long型数据给客户端，就需要经过出站流程，编码，发送
        Long now = Instant.now().toEpochMilli();
        System.out.println("给客户端发送回报："+now);
        ctx.writeAndFlush(now);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.writeAndFlush(cause.getMessage());
    }
}

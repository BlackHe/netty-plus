package io.netty.tcp.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

public class MyServerHandler extends ChannelInboundHandlerAdapter {


    int count = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
        if (msg instanceof ByteBuf){
            ByteBuf byteBuf = (ByteBuf) msg;
            byte[] recv = ByteBufUtil.getBytes(byteBuf.readBytes(byteBuf.readableBytes()));
            String s = new String(recv, StandardCharsets.UTF_8);
            System.out.println(s);
            System.out.println("收到第："+ (++count) +" 条消息\n\n\n");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println(cause.getMessage());
    }

    /**
     * 当客户端 channel被注册到多路复用器后，会调用此方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端被注册到多路复用器");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active.....");
    }
}

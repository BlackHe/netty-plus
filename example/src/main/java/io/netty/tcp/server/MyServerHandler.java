package io.netty.tcp.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
        if (msg instanceof ByteBuf){
            ByteBuf byteBuf = (ByteBuf) msg;
            ByteBuf recvMsg = byteBuf.readBytes(byteBuf.readableBytes());
            String s = ByteBufUtil.prettyHexDump(recvMsg);
            System.out.println(s);
            System.out.println("---------------------------");
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
        super.channelRegistered(ctx);
    }
}

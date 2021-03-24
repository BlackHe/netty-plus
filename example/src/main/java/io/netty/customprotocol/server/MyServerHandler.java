package io.netty.customprotocol.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.customprotocol.protocol.MyTransportMessage;


public class MyServerHandler extends SimpleChannelInboundHandler<MyTransportMessage> {


    int count = 0;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyTransportMessage msg) throws Exception {
        System.out.println("[MyServerHandler]收到解码后的消息对象为:" +msg );
        System.out.println("[MyServerHandler]第："+(++count) +" 次收到消息\n");
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
        System.out.println("客户端被注册到多路复用器\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active.....\n");
    }
}

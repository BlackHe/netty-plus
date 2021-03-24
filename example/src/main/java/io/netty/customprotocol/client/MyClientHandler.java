package io.netty.customprotocol.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.customprotocol.protocol.MyTransportMessage;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.UUID;

public class MyClientHandler extends SimpleChannelInboundHandler<MyTransportMessage> {

    int count = 0 ;
    String msg = "小猪佩奇six";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String sald = UUID.randomUUID().toString().substring(0, new Random().nextInt(16));
            byte[] content = (msg + sald +i).getBytes(StandardCharsets.UTF_8);
            MyTransportMessage msgWillSend = new MyTransportMessage(content.length, content);
            ctx.writeAndFlush(msgWillSend);
            System.out.println("已经发送了："+(++count) + "条消息\n");
        }
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyTransportMessage msg) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
    }
}

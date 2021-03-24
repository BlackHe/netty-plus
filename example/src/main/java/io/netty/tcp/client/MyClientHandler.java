package io.netty.tcp.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MyClientHandler extends ChannelInboundHandlerAdapter {

    int count = 0 ;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            byte[] bytes = ("小猪佩奇哈哈哈-" + i).getBytes(StandardCharsets.UTF_8);
            ByteBuf content = Unpooled.buffer(bytes.length);
            content.writeBytes(bytes);
            ctx.writeAndFlush(content);
            System.out.println("发送第："+ (++count) +" 条消息");
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}

package io.netty.codec.demo.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class SpCodecLongToByteEncoder extends MessageToByteEncoder<Long> {


    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("SpCodecLongToByteEncoder: 编码消息并发送："+msg);
        out.writeLong(msg);
    }
}

package io.netty.customprotocol.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.customprotocol.protocol.MyTransportMessage;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyReplayingDecoder extends ReplayingDecoder<MyTransportMessage> {

    int count = 0;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("[解码器]第："+(++count) +" 次收到消息");
        System.out.println("[解码器]进行编码...");
        int msgLen = in.readInt();
        System.out.println("[解码器]解码出消息长度为："+msgLen);
        out.add(new MyTransportMessage(msgLen, ByteBufUtil.getBytes(in.readBytes(msgLen))));
        System.out.println("[解码器]解码完成\n");
    }
}

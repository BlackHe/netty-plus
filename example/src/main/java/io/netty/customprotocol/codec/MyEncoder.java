package io.netty.customprotocol.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.customprotocol.protocol.MyTransportMessage;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyEncoder extends MessageToByteEncoder<MyTransportMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MyTransportMessage msg, ByteBuf out) throws Exception {
        System.out.println("[编码器]对传输对象："+msg + "进行编码...");
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getPayload());
        System.out.println("[编码器]编码完成\n");
    }
}

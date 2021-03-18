package io.netty.codec.demo.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class SpCodecByteToLongDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("SpCodecByteToLongDecoder：准备解码");

        if (in.readableBytes() < 8){
            System.err.println("可读字节数不足8个字节，无法解码为Long型....");
        }
        // 如果可读字节超过8，则该解码器会被多次调用，直到可读取的入站消息读取完
        System.out.println("SpCodecByteToLongDecoder：从入站消息中解码出一个Long消息");
        out.add(in.readLong());
    }
}

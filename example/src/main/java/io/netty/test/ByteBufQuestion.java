package io.netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class ByteBufQuestion {

    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buffer1 = Unpooled.buffer(15);
        ByteBuf buffer = Unpooled.copiedBuffer("netty in action", utf8);
        System.out.println(buffer.readerIndex());
        System.out.println(buffer.readBytes(buffer1));
        System.out.println(buffer.readerIndex());


        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.directBuffer(1024);


        int i = ByteBufUtil.utf8Bytes("666");
        String s = ByteBufUtil.hexDump(buffer1);
        System.out.println(s);
    }
}

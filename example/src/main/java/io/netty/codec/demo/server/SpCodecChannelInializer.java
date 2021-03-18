package io.netty.codec.demo.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class SpCodecChannelInializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new SpCodecByteToLongDecoder());
        pipeline.addLast(new SpCodecLongToByteEncoder());
//        pipeline.addLast(new SpCodecServerChannelMonitorHandler());
        pipeline.addLast(new SpCodecServerHandler());
    }
}

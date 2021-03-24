package io.netty.tcp.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {

    public static void main(String[] args) throws Exception{
        NioEventLoopGroup clientGroup = new NioEventLoopGroup(1);

        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(clientGroup);

        bootstrap.channel(NioSocketChannel.class);

        bootstrap.handler(new MyClientChannelInitializer());

        ChannelFuture future = bootstrap.connect("localhost", 8080).sync();

        future.channel().closeFuture().sync();
    }
}

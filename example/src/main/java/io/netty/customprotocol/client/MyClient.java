package io.netty.customprotocol.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {

    public static void main(String[] args) throws Exception{
        EventLoopGroup clientGroup = new NioEventLoopGroup(1);
        try{
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(clientGroup);

            bootstrap.channel(NioSocketChannel.class);

            bootstrap.option(ChannelOption.TCP_NODELAY,true);

            bootstrap.handler(new MyClientChannelInitializer());

            ChannelFuture future = bootstrap.connect("localhost", 8080).sync();

            future.channel().closeFuture().sync();
        }finally {
            clientGroup.shutdownGracefully();
        }


    }
}

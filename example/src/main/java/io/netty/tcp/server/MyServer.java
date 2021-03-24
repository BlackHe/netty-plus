package io.netty.tcp.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {

    public static void main(String[] args) throws Exception{
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup,workGroup);

        bootstrap.channel(NioServerSocketChannel.class);

        bootstrap.childHandler(new MyChannelInitializer());

        ChannelFuture channelFuture = bootstrap.bind(8080).sync();
        System.out.println("-----------------------server已经启动：8080端口--------------------");

        channelFuture.channel().closeFuture().sync();

    }
}

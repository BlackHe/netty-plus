package io.netty.codec.demo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class SpCodecServer {

    public static void main(String[] args) throws Exception{
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup,workGroup);
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new SpCodecChannelInializer());

            ChannelFuture future = bootstrap.bind(8080).sync();

            future.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}

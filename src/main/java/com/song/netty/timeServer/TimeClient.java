package com.song.netty.timeServer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @ClassName TimeClient
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-22 13:44
 * @Version 1.0.0
 */
public class TimeClient {

    public void connect(int port, String address) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //客户端启动辅助类
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ch.pipeline().addLast(new TimeClientHandler());
                        }
                    });

            ChannelFuture future = b.connect(address, port).sync();

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

    public static void main(String[]args){
        int port = 8080;
        String host = "127.0.0.1";
        if (args != null && args.length > 0) {

            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
            }
        }

        new TimeClient().connect(port,host);
    }
}

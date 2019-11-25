package com.song.netty.timeServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;


/**
 * @ClassName TimeServer
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-22 12:42
 * @Version 1.0.0
 */
public class TimeServer {

    public void bind(int port) {
        //配置服务端的NIO线程组
        //专门用来进行网络事件的处理，也就是Rectors线程组
        //这里创建两个的原因是因为；一个用于服务端接受客户端的链接、另一个用来进行SocketChannel的读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //用于启动netty服务端的启动辅助类，降低服务端的开发复杂度
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    //配置TCP参数，此处将他的backlog设置为1024
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //I/O事件的处理类，主要用于处理网络I/O事件，例如记录日志，对小心进行加解码
                    .childHandler(new ChildChannelHanler());
            //服务端启动服务类配置完成之后，调用他的bind进行端口绑定，随后调用他的同步阻塞方法等待绑定完成，完成之后netty会返回一个channelFuture，主要用于异步操作的通知回调
            //绑定端口，同步等待成功
            ChannelFuture future = b.bind(port).sync();
            //等待服务监听端口关闭
            //用来阻塞，等待服务端链路关闭之后main函数才会退出
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //优雅关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }

    private class ChildChannelHanler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(io.netty.channel.socket.SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new TimeServerHandler());
            ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {

            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
            }
        }
        new TimeServer().bind(port);
    }

}

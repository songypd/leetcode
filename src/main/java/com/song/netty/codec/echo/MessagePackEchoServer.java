package com.song.netty.codec.echo;

import com.song.netty.codec.msgpack.MsgPackDecoder;
import com.song.netty.codec.msgpack.MsgPackEncoder;
import com.song.netty.echo.EchoServer;
import com.song.netty.echo.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @ClassName EchoServer
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-24 00:39
 * @Version 1.0.0
 */
public class MessagePackEchoServer {

    public void bind(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .option(ChannelOption.SO_BACKLOG, 256)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("msgpack decoder" ,new MsgPackDecoder());
                            ch.pipeline().addLast("msgpack encoder" ,new MsgPackEncoder());
                            ch.pipeline().addLast(new MessagePackEchoServerHandler());
                        }
                    });
            ChannelFuture future = bootstrap.bind(port).sync();


            future.channel().closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[]args){
        int port = 8080;

        if (args.length!= 0&&args[0]!=null){
            port = Integer.parseInt(args[0]);
        }

        new MessagePackEchoServer().bind(port);
    }
}

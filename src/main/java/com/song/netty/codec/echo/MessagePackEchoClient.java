package com.song.netty.codec.echo;

import com.song.netty.codec.msgpack.MsgPackDecoder;
import com.song.netty.codec.msgpack.MsgPackEncoder;
import com.song.netty.echo.EchoClient;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @ClassName EchoClient
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-24 01:08
 * @Version 1.0.0
 */
public class MessagePackEchoClient {

    public void connect(String host, int port) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).option(ChannelOption.TCP_NODELAY, true)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new MessagePackEchoClientHandler());
                            ch.pipeline().addLast("msgpack decoder" ,new MsgPackDecoder());
                            ch.pipeline().addLast("msgpack encoder" ,new MsgPackEncoder());

                        }
                    });

            ChannelFuture future = bootstrap.connect(host, port).sync();

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

    public static void  main(String[]args){
        int port = 8080;
        if (args.length!=0&&args[0]!=null){
            port = Integer.parseInt(args[0]);
        }

        new MessagePackEchoClient().connect("127.0.0.1",port);
    }
}

package com.song.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName EchoServerHandler
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-24 00:49
 * @Version 1.0.0
 */
@Slf4j
public class EchoServerHandler extends ChannelHandlerAdapter {

    int counter = 0;

    private static final String delimiter = "$_";

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;

        log.info("this is {} times receive client [{}]", counter++, body);

        ByteBuf echo = Unpooled.copiedBuffer((body + delimiter).getBytes());
        ctx.writeAndFlush(echo);


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }
}

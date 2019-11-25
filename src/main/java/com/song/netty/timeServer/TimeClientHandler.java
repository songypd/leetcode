package com.song.netty.timeServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TimeClientHandler
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-22 13:55
 * @Version 1.0.0
 */
@Slf4j
public class TimeClientHandler extends ChannelHandlerAdapter {

    private final ByteBuf firstMsg;

    public TimeClientHandler() {
        byte[] req = "QUERY time".getBytes();
        firstMsg = Unpooled.buffer(req.length);
        firstMsg.writeBytes(req);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        log.error(cause.toString());
    }

    /**
     * 当客户端与服务端建立TCP链路之后，netty的NIO线程就会调用channelActive 方法发送查询时间的指令到服务端
     * 调用writeAndFlush 方法将请求信息发送给服务器
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.writeAndFlush(firstMsg);
    }

    /**
     * 当服务端返回应答信息是channelRead 方法被调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] res = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(res);
        log.error("Now is" + new String(res, CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);

    }
}

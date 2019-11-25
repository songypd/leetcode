package com.song.netty.timeServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

import java.util.Date;

/**
 * @ClassName TimeServerHandler
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-22 13:23
 * @Version 1.0.0
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        //获取缓冲区可读的字节数，根据可读的字节数，创建字节数组
        byte[] req = new byte[byteBuf.readableBytes()];
        //将缓冲区中的字节数组复制到新创建的字节数组中去
        byteBuf.readBytes(req);
        String body = new String(req, CharsetUtil.UTF_8);
        System.out.println("the time server received "+body);
        String concurrentTime = "query time".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER!";
        ByteBuf resp = Unpooled.copiedBuffer(concurrentTime.getBytes());
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        //flush的作用是将消息发送队列中的消息写入到socketChannel中发送给对方，
        //从性能角度上讲，不用频繁的唤醒selector进行消息的发送，netty的write方法并不是将消息直接写到socketchannel中，而是写到消息缓冲队列中
        //再通过调用flush的方法，将发送缓冲区中的消息全部写到SocketChannel中
        ctx.flush();
    }
}

package com.song.netty.codec.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @ClassName MsgPackageEncoder
 * @Description TODO
 * @Author songyp
 * @Date 2019-12-04 12:07
 * @Version 1.0.0
 */
public class MsgPackEncoder extends MessageToByteEncoder<Object> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        MessagePack pack = new MessagePack();
        byte[] raw = pack.write(msg);
        out.writeBytes(raw);
    }
}

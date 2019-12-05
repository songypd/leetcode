package com.song.netty.codec.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * @ClassName MsgPackDecoder
 * @Description TODO
 * @Author songyp
 * @Date 2019-12-04 12:12
 * @Version 1.0.0
 */
public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {
    /**
     * 解码操作的流程
     * 首先从数据流msg中获取需要解码的字节数组，然后调用messagepack中的read方法将其反序列化为object对象
     * 将解码后的对象存储到解码列表out中，这样就完成了messagePack的解码动作
     * @param ctx
     * @param msg
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        final byte[] array;
        final int length = msg.readableBytes();
        array = new byte[length];
        msg.getBytes(msg.readerIndex(), array, 0, length);
        MessagePack pack = new MessagePack();
        out.add(pack.read(array));
    }
}

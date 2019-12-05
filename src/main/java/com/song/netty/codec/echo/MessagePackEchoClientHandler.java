package com.song.netty.codec.echo;

import com.song.netty.codec.msgpack.UserInfo;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName EchoClientHandler
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-24 01:15
 * @Version 1.0.0
 */
@Slf4j
public class MessagePackEchoClientHandler extends ChannelHandlerAdapter {


    private static final String ECHO_REQ = " my name is songyuanpeng ,this is my second time to use netty ";

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        log.info("client receive the msgpack message ", ctx.write(msg));
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        List<UserInfo> info = getUserInfos();
        info.forEach(e -> {
            ctx.write(e);
        });
        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    private List<UserInfo> getUserInfos() {
        int size = 5;
        List<UserInfo> infos = new LinkedList<>();
        for (; ; ) {
            infos.add(UserInfo.builder()
                    .age("100")
                    .name(size + "我是")
                    .sex("男男女女")
                    .build());
            size--;
            if (size < 0) {
                break;
            }
        }
        return infos;
    }
}

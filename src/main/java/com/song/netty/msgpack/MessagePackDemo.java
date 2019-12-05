package com.song.netty.msgpack;

import lombok.extern.slf4j.Slf4j;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MessagePackDemo
 * @Description TODO
 * @Author songyp
 * @Date 2019-12-04 00:31
 * @Version 1.0.0
 */
@Slf4j
public class MessagePackDemo {
    public static void main(String[]args) throws IOException {
        List<String> demo = new ArrayList<>();
        demo.add("ni");
        demo.add("wo");
        demo.add("ta");
        MessagePack msgPack = new MessagePack();
        //serialize  序列化
        byte[] raw = msgPack.write(demo);
        //deserialize directly using  a template 反序列化
        List<String> target = msgPack.read(raw, Templates.tList(Templates.TString));
        target.forEach(e->{
            log.error(e);
        });

    }
}

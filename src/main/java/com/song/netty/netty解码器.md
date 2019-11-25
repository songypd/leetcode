new StringDecoder()
    ;;将接收到的对象专程字符串，然后调用后面其他的handler

new LineBasedFrameDecoder(1024)
    ;;他的工作原理很简单，就是依次遍历ByteBuf中的可读字节，判读是否有"\n"或者"\r\n",如果有就以此作为结束位置，从可读索引到结束位置区间的字节就组成了一行数据
    它是以换行符为结束标志的解码器，支持携带结束符和不携带结束符的两种方式，
    支持配置单行最大长度；
                如果连续读到最大长度仍未出现换行结束符，就会抛出异常同时忽略掉之前已经读到的异常码流

new DelimiterBasedFrameDecoder()
     ;;可以完成以分隔符作为结束标志的消息的转码

new FixedLengthFrameDecoder()
    ;;可以完成对定长信息的转码
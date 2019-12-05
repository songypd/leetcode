package com.song.netty.codec.msgpack;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author songyp
 * @Date 2019-12-04 12:41
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {

    private String age;

    private String sex;

    private String name;


}

package com.song;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/26
 * @description 字母重复统计
 * Laughter is poison to fear.
 */
public class Test {
    public static void main(String[] args) {
        String demo = "aabbccdde";
        Map<String, Integer> test = test(demo);
        System.out.println(JSON.toJSONString(test));
    }

    public static Map<String, Integer> test(String args) {
        if (null == args) {
            return new HashMap<>();
        }
        Map<String, Integer> res = new HashMap<>();
        String[] split = args.split("");
        for (String str : split) {
                if (res.containsKey(str)) {
                    res.put(str, res.get(str) + 1);
                } else {
                    res.put(str, 1);
                }

        }
        for (String k:res.keySet()){
            if (res.get(k) == 1){
                res.remove(k);
            }
        }
        List<Map.Entry<String, Integer>> collect = res.entrySet().stream().filter(e -> e.getValue() != 1).collect(Collectors.toList());
        return res;
    }
}

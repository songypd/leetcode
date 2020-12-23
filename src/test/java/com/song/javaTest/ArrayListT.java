package com.song.javaTest;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArrayListT
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-18 18:55
 */
public class ArrayListT {

    public static void main(String[] args) {
        List t = new ArrayList<Integer>();
        t.add(0,1);

        System.out.println(JSON.toJSONString(t));

    }
}

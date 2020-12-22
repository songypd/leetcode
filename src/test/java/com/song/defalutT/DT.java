package com.song.defalutT;

import lombok.Data;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class DT {
    @Test
    public void Test1() {
        Optional demo = Optional.empty();
        Optional alseEmpty = Optional.ofNullable(null);
//Return {@code true} if there is a value present, otherwise {@code false}.
        Assert.assertFalse(demo.isPresent());

        Assert.assertFalse(alseEmpty.isPresent());

        Assert.assertEquals("c", demo.orElseGet(() -> "c"));

        List l1 = new ArrayList();
//        l1.stream().collect(Collectors.toCollection(TreeSet::new));
        l1.stream().collect(toCollection(TreeSet::new));


        List<clazz> clazzes = Lists.newArrayList();
        //按照是否开班进行区分
        Map<Boolean, List<clazz>> collect = clazzes.stream().collect(partitioningBy(clazz::getOpen));
        Map<Boolean, List<clazz>> collect1 = clazzes.stream().collect(groupingBy(clazz::getOpen));
        //分组并将每组的个数输出
        Map<Integer, Long> collect2 = clazzes.stream().collect(groupingBy(clazz::getCode, counting()));
        Map<Integer, List<field>> collect3 = clazzes.stream().collect(groupingBy(clazz::getCode, mapping(clazz::getField, toList())));
        String nameAdd = clazzes.stream().map(clazz::getName).collect(joining(",", "[", "]"));

    }
}

@Data
class clazz {
    private String name;
    private Integer code;
    private Boolean open;
    private field field;

}

@Data
class field {
    private String name;
}
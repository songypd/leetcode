package com.song.defalutT;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class DT {
    @Test
    public void Test1() {
        Optional demo = Optional.empty();
        Optional alseEmpty = Optional.ofNullable(null);
//Return {@code true} if there is a value present, otherwise {@code false}.
        Assert.assertFalse(demo.isPresent());

        Assert.assertFalse(alseEmpty.isPresent());

        Assert.assertEquals("c",demo.orElseGet(()->"c"));
    }
}

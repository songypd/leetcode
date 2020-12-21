package com.song.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lambdaT {

    public static void main(String[] args) {
        List<Track> tracks = Arrays.asList(new Track("yehuimei",100),new Track("qilixiang",200),new Track("niuzaihenmang",170));
    //获取最小
        Track track = tracks.stream().min( Comparator.comparing(t->t.getLength())).get();
        Track trackMax = tracks.stream().max( Comparator.comparing(t->t.getLength())).get();
        System.out.println("end");
    }
}

class Track{
    String name;
    Integer length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Track(String name, Integer length) {
        this.name = name;
        this.length = length;
    }
}
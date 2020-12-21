package com.song.lambda;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionT {

    public static void main(String[] args) {
//        test1(10,s->String.valueOf(s));
//        test2("20",s->Integer.parseInt(s),l->String.valueOf(l+1));
//        Date dateformat = dateformat(System.currentTimeMillis(), i -> new Date(i));
//        System.out.println(str.get());
//        add(10, 2, (a, b) -> (a + b));
        System.out.println("end");
    };

    public static void test1(Integer integer, Function<Integer, String> function) {
        String s = function.apply(integer);
        System.out.println(s.getClass());
    }

//    private static void add(Integer a,Integer b, Operators<Integer> f1) {
//        Integer apply = f1.apply(a+b);
//
//    }

    public static void test2(String s, Function<String, Integer> function, Function<Integer, String> function2) {
        String r = function.andThen(function2).apply(s);
        System.out.println(r.getClass() + "---" + r);
    }

    //计算器程序
    private static Date dateformat(Long i, Function<Long, Date> f) {
        Date d = f.apply(i);
        System.out.println(d);
        return d;
    }

    public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

    public static ThreadLocal<String> str = ThreadLocal.withInitial(() -> String.valueOf("Helo"));

}

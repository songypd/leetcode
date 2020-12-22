package com.song.javaTest;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class CollectionT {

    public static void main(String[] args) {
        List l1 = Arrays.asList(1, 2, 4, 5, 6, 7);

        /**
         * The default implementation traverses all elements of the collection using
         * its {@link #iterator}.  Each matching element is removed using
         * {@link Iterator#remove()}.  If the collection's iterator does not
         * support removal then an {@code UnsupportedOperationException} will be
         * thrown on the first matching element.
         */
        l1.removeIf((Predicate<Integer>) o -> o > 3);

        System.out.println(JSON.toJSONString(l1));

//        Collection<Person> collection = new ArrayList();
//        collection.add(new Person("张三", 22, "男"));
//        collection.add(new Person("李四", 19, "女"));
//        collection.add(new Person("王五", 34, "男"));
//        collection.add(new Person("赵六", 30, "男"));
//        collection.add(new Person("田七", 25, "女"));
//        collection.removeIf(person -> person.getAge()>30);
//        System.out.println(JSON.toJSONString(collection));
    }
}

class Person {
    private String name;//姓名
    private Integer age;//年龄
    private String gender;//性别

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person() {
    }

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //重写toString，方便观看结果
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
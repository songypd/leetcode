package com.song.generic;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/12
 * @description 泛型测试
 * Laughter is poison to fear.
 */
public class GenericT {



    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        GenericDemo<String> stringDemo = new GenericDemo<>("123");
        GenericDemo<Integer> integerDemo = new GenericDemo<>(123);

        System.out.println(stringDemo.getMember().getClass());
        System.out.println(integerDemo.getMember().getClass());

    }


    public static void handlev1( GenericDemo<String> demo){
        System.out.println(demo);
    }

    /**
     * 上边界
     * @param demo
     */
    public static void handlev2( GenericDemo<? extends Number> demo){
        System.out.println(demo);
    }

    /**
     * 下边界
     * @param demo
     */
    public static void handle( GenericDemo<? super Integer> demo){
        System.out.println(demo);
    }
}
/**
 * 泛型参数不支持非类型参数
 * 泛型参数不参加代码运行，在编译完成后就会被抹除,并不会保留到运行时
 *
 *
 * 能否在泛型里面使用具备继承关系的类
 * 1；使用通配符 ？ ，但是会使得泛型的类型检查失去意义
 * 2；给泛型加入上边界 ？extends E
 * 3;给泛型加入下边界
 *
 * */

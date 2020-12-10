package com.song.javaTest;

/**
 * @ClassName ClassLoadertest
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-11-25 11:34
 */
public class ClassLoadertest {
    public static void main(String[] args) throws Exception {
        String user = "com.song.javaTest.User";
        test(user);
    }

    private static void test(String user) throws Exception {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass(user);
        System.out.println("ClassLoader.getSystemClassLoader() user " + aClass);
        System.out.println("-------------------------------------------------");
        Class<?> aClass1 = Class.forName(user);
        System.out.println("Class.forName(user) user " + aClass1);
        System.out.println("-------------------------------------------------");
    }

    /**
     * 执行结果；
     * ClassLoader.getSystemClassLoader() user class com.song.javaTest.User
     * -------------------------------------------------
     * i am static method
     * Class.forName(user) user class com.song.javaTest.User
     * -------------------------------------------------
     * 原因
     *  @CallerSensitive
     *     public static Class<?> forName(String className)
     *                 throws ClassNotFoundException {
     *         Class<?> caller = Reflection.getCallerClass();
     *         return forName0(className, true, ClassLoader.getClassLoader(caller), caller);
     *     }
     *     默认初始化实例
     *  而ClassLoader.getSystemClassLoader() 仅仅是将。class文件加载到jvm中
     *
     * 类加载的过程
     * 解析-》验证-》准备-》解析-》初始化-》使用-》卸载
     */
}

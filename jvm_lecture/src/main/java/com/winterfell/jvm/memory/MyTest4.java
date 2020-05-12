package com.winterfell.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 方法区产生内存溢出
 *
 * @author winterfell
 **/
public class MyTest4 {

    // 1.显式设定元空间大小


    public static void main(String[] args) {

        // 运行期间无限创建Class
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
            System.out.println("hello world");

            enhancer.create();
        }
    }
}

package com.answer.dynamic_proxy;

/**
 * created by liufeng
 * 2018/10/19
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        ProxyInstance proxyInstance=new ProxyInstance();
        DynamicProxyInterface dynamicProxyInterface=proxyInstance.getProxy();
        dynamicProxyInterface.dynamicProxy();
    }
}

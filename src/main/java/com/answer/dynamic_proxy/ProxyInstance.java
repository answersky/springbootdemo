package com.answer.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created by liufeng
 * 2018/10/19
 */
public class ProxyInstance {
    private DynamicProxyInterface dynamicProxyInterface=new DynamicProxyImpl();

    public DynamicProxyInterface getProxy(){
        return (DynamicProxyInterface) Proxy.newProxyInstance(ProxyInstance.class.getClassLoader(), dynamicProxyInterface.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName=method.getName();
                        System.out.println("调用的方法名："+methodName);
                        return method.invoke(dynamicProxyInterface,args);
                    }
                });
    }
}

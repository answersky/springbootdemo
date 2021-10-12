package com.answer.demo.mybatisDemo;

import com.answer.demo.mybatisDemo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created by liufeng
 * 2021/10/12
 * 通过FactoryBean 来生成一个对象
 * 这里会生成2个对象，一个MybatisBeanFactoryBean对象，一个是getobject返回的对象
 */
public class MybatisBeanFactoryBean implements FactoryBean {
    private Class mapperClass;

    private SqlSession sqlSession;

    public MybatisBeanFactoryBean(Class mapperClass){
        this.mapperClass=mapperClass;
    }

    public MybatisBeanFactoryBean(SqlSessionFactory sqlSessionFactory){
        this.sqlSession=sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {

        //mybatis实现 底层就是下面的动态代理实现方式  todo SqlSessionFactory暂未实现
//        return sqlSession.getMapper(mapperClass);

        //mybatis底层是通过jdk动态代理，将usermapper接口生成一个代理对象返回
        return Proxy.newProxyInstance(MybatisBeanFactoryBean.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //此处就是mybatis 通过sqlseesion执行sql语句返回结果
                return null;
            }
        });
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

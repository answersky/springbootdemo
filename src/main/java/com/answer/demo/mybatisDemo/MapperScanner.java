package com.answer.demo.mybatisDemo;

import com.answer.demo.mybatisDemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * created by liufeng
 * 2021/10/12
 * ClassPathBeanDefinitionScanner 扫描的类不管是接口还是类都会扫描
 * 我们自己实现的只去扫描接口
 */
public class MapperScanner extends ClassPathBeanDefinitionScanner {

    public MapperScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition){
        //如果是接口返回true
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages){
        //得到的是接口对象
        Set<BeanDefinitionHolder> set=super.doScan(basePackages);
        //转成我们需要的对象
        for(BeanDefinitionHolder beanDefinitionHolder:set){
            AbstractBeanDefinition beanDefinition= (AbstractBeanDefinition) beanDefinitionHolder.getBeanDefinition();
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClass(MybatisBeanFactoryBean.class);
        }

        return set;
    }
}

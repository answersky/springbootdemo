package com.answer.demo.mybatisDemo;

import com.answer.demo.mybatisDemo.mapper.StudentMapper;
import com.answer.demo.mybatisDemo.mapper.UserMapper;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * created by liufeng
 * 2021/10/12
 * 模拟spring整合mybatis生成的代理对象如何放入spring容器
 */
public class MybatisBeanRegister implements ImportBeanDefinitionRegistrar {
    private static final String path="com.answer.demo.mybatisDemo.mapper";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        //优化，通过扫描mapper接口的方式，找某个路径下所有的mapper接口
        ClassPathBeanDefinitionScanner scanner=new MapperScanner(beanDefinitionRegistry);
        scanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });
        scanner.scan(path);

        /*
        spring通过AbstractBeanDefinition来创建一个bean，也可以通过注解@Autowired  @bean 等方式（注解的底层也是通过AbstractBeanDefinition 来实现）
        AbstractBeanDefinition beanDefinition=BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(MybatisBeanFactoryBean.class);
        //将usermapper通过构造方法传递进去
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
        beanDefinitionRegistry.registerBeanDefinition("userMapper",beanDefinition);

        AbstractBeanDefinition beanDefinition1=BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition1.setBeanClass(MybatisBeanFactoryBean.class);
        //将usermapper通过构造方法传递进去
        beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(StudentMapper.class);
        beanDefinitionRegistry.registerBeanDefinition("studentMapper",beanDefinition1);*/
    }
}

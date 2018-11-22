package com.answer.demo.spring;

import com.answer.config.JavaConfig;
import com.answer.demo.spring.scope.PrototypeClass;
import com.answer.demo.spring.scope.SingleClass;
import com.answer.service.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by liufeng
 * 2018/9/12
 */
public class JavaConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        //JavaConfig 配置的bean
        UseFunctionService useFunctionService=context.getBean(UseFunctionService.class);
        useFunctionService.say();

        //JavaConfig ComponentScan注解扫描注入的bean
        SingleClass singleClass1=context.getBean(SingleClass.class);
        SingleClass singleClass2=context.getBean(SingleClass.class);
        System.out.println("singleClass1==singleClass2:"+(singleClass1==singleClass2));

        PrototypeClass prototypeClass1=context.getBean(PrototypeClass.class);
        PrototypeClass prototypeClass2=context.getBean(PrototypeClass.class);
        System.out.println("prototypeClass1==prototypeClass2:"+(prototypeClass1==prototypeClass2));

        context.close();
    }
}

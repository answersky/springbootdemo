package com.answer.config;

import com.answer.service.FunctinonService;
import com.answer.service.UseFunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * created by liufeng
 * 2018/9/12
 */
@Configuration
@ComponentScan({"com.answer.demo.spring.scope"})
public class JavaConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public FunctinonService functinonService(){
        return new FunctinonService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService=new UseFunctionService();
        useFunctionService.setFunctinonService(functinonService());
        return useFunctionService;
    }

}

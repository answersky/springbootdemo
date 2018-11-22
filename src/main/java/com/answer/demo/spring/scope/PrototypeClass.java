package com.answer.demo.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * created by liufeng
 * 2018/9/12
 */
@Service
@Scope("prototype")
public class PrototypeClass {
}

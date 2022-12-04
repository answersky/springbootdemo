package com.answer.controller;

import com.answer.service.ValueAnnotateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by liufeng
 * 2020/7/14
 */
@Controller
public class IndexController {
    @Autowired
    private ValueAnnotateService valueAnnotateService;

//    @Autowired
//    private com.answer.demospringbootstarter.service.DemoService demoService;

    @RequestMapping("/index")
    @ResponseBody
    public String index() throws Exception {
        valueAnnotateService.systemValue();
        return "2";
    }

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/springBootStater")
    @ResponseBody
    public String springstater() {
//        demoService.printProperties();
        return "springstater test";
    }


    @RequestMapping("/testException")
    public void testException() throws Exception {
        throw new Exception("test exception");
    }
}

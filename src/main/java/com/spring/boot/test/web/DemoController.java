package com.spring.boot.test.web;

import com.spring.boot.test.bean.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("zzz");
        demo.setAge(18);
        demo.setAddress("广东省东莞市大岭山");
        return demo;
    }

    @RequestMapping("/zeroException")
    public int zeroException(){
        return 100/0;
    }
}

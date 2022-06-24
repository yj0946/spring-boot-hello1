package com.spring.boot.test.web;

import com.spring.boot.test.bean.Demo;
import com.spring.boot.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

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

    @RequestMapping("/save")
    public String save() {
        Demo demo = new Demo();
        demo.setId(2);
        demo.setName("angle");
        demo.setAge(50);
        demo.setAddress("广东省东莞市大岭山");
        demoService.save(demo);
        return "ok the data was saved";
    }
}

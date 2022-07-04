package com.spring.boot.test.web;

import com.spring.boot.test.bean.Demo;
import com.spring.boot.test.bean.LstDemo;
import com.spring.boot.test.service.DemoService;
import com.spring.boot.test.service.DemoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoService2 demoService2;

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
        Demo demo;
        for (int i = 0; i < 1000; i++) {
            demo = new Demo();
            demo.setId(2);
            demo.setName("angle");
            demo.setAge(50);
            demo.setAddress("广东省东莞市大岭山");
            demoService.save(demo);
        }
        return "ok the data was saved";
    }

    @RequestMapping("/show")
    public List<Demo> showDemo(@RequestParam(value = "no[]")Integer[] ids) {
        return demoService2.GetByIds(ids);
    }

    //List
    @RequestMapping(value = "/display", method =  RequestMethod.POST )
    public String display(@RequestParam(value = "ids", required = false)List<Integer> ids) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ids.size(); i++) {
            sb.append(ids.get(i));
        }
        return sb.toString();
    }

    //JSON
    @RequestMapping(value = "/displaySecond", method =  RequestMethod.POST )
    public String displaySecond(@RequestBody List<Integer> ids) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ids.size(); i++) {
            sb.append(ids.get(i));
        }
        return sb.toString();
    }
}

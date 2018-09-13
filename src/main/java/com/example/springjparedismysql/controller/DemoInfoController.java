package com.example.springjparedismysql.controller;

import com.example.springjparedismysql.bean.DemoInfo;
import com.example.springjparedismysql.service.impl.DemoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author created by qwb on 2018/9/13 11:28
 */
@Controller
public class DemoInfoController {
    @Autowired
    DemoInfoService demoInfoService;


    @RequestMapping("/test")
    public @ResponseBody
    String test(){
        DemoInfo loaded = demoInfoService.findById(1);
        System.out.println("loaded="+loaded);
        DemoInfo cached = demoInfoService.findById(1);
        System.out.println("cached="+cached);
        loaded = demoInfoService.findById(2);
        System.out.println("loaded2="+loaded);
        return "ok";
    }


    @RequestMapping("/delete")
    public @ResponseBody String delete(long id){
        demoInfoService.deleteFromCache(id);
        return"ok";
    }

    @RequestMapping("/test1")
    public @ResponseBody String test1(){
        demoInfoService.test();
        System.out.println("DemoInfoController.test1()");
        return "ok";
    }

    @RequestMapping("/add/demoinfo")
    public @ResponseBody String save(DemoInfo demoInfo){
        DemoInfo demoInfo1 = new DemoInfo();
//        demoInfo1.setId(3);
        demoInfo1.setName("qwb");
        demoInfo1.setPwd("123456");
        demoInfoService.save(demoInfo1);
        System.out.println("-----保存成功------");
        return "ok";
    }

}

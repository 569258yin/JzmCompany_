package com.jinzhimu.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YH on 2017/6/15.
 */
@Controller
public class ViewController{

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}

package com.coin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("sysName", "活动中心后台");
        return mv;
    }

}

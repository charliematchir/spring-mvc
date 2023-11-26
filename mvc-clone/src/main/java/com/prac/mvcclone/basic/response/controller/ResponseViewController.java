package com.prac.mvcclone.basic.response.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ResponseViewController {

    @RequestMapping("/responseview1")
    public ModelAndView responseView1() {
        ModelAndView mav = new ModelAndView("/hello")
                .addObject("data", "hello");
        return mav;
    }

    @RequestMapping("/responseview2")
    public String responseView2(Model model) {
        model.addAttribute("data", "hello");
        return "/hello";
    }

    // RequestMapping의 url이 view와 이름이 같으면 return 안해도 됨
    // 그래도 명시적으로 함


    

}

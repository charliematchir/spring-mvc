package com.prac.mvcclone.basic.request.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prac.mvcclone.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;


@Slf4j
@Controller
public class RequestParamController {


    // getParameter
    @RequestMapping("/requestparam-get")
    public void requestParam1(HttpServletRequest req, HttpServletResponse res)
        throws IOException {
        String name = req.getParameter("username");
        Integer age = Integer.parseInt(req.getParameter("age"));
        log.info("username={}, age={}", name, age);
        res.getWriter().write("ok");
    }

    // RequestParam
    // 아예 어노테이션 생략해도 되지만 파라미터 받는것 명시적으로 표현하기위해 적는 편
    @ResponseBody
    @RequestMapping("/reqeustparam-param")
    public String requestParam2(@RequestParam("username") String name,
                                   @RequestParam int age) {
        log.info("username={}, age={}", name, age);
        return "ok";
    }

    // ModelAttribute (생략 가능)
    // 파라미터 객체에 자동으로 담기
    @ResponseBody
    @RequestMapping("/reqeustparam-attribute")
    public String requestParamForm(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}

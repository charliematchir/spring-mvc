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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {

    private ObjectMapper mapper = new ObjectMapper();

    // HttpServletRequest, HttpServletResponse
    @PostMapping("/requestbody-json1")
    public void requestBodyJson1 (HttpServletRequest req, HttpServletResponse res) throws IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("msgBody = {}", messageBody);

        HelloData helloData = mapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        res.getWriter().write("ok");
    }

    // RequestBody
    @ResponseBody
    @PostMapping("/requestbody-json2")
    public String requestBodyJson2 (@RequestBody String messageBody) throws IOException {
        log.info("msgBody = {}", messageBody);

        HelloData helloData = mapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    // RequestBody - Http 메시지 컨버터 자동 매핑
    @ResponseBody
    @PostMapping("/requestbody-json3")
    public String requestBodyJson3 (@RequestBody HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    // HttpEntity
    @ResponseBody
    @PostMapping("/requestbody-json4")
    public String requestBodyJson4 (HttpEntity<HelloData> httpEntity) {
        HelloData helloData = httpEntity.getBody();
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }


    // Json을 객체로 전환해서 받고, 객체 반환시 Json으로 전환해서 return
    @ResponseBody
    @PostMapping("/requestbody-json5")
    public HelloData requestBodyJson5 (@RequestBody HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return helloData;	// 객체 반환시 자동으로 Json으로 전환해줌
    }
}

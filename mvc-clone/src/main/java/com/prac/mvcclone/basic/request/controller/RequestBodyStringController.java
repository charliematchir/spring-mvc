package com.prac.mvcclone.basic.request.controller;

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
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;


@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/requestbody1")
    public void requestBody1(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("msgBody = {}", messageBody);
        res.getWriter().write("ok");
    }

    @PostMapping("/requestbody2")
    public void requestBody2(InputStream inputStream, Writer resWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("msgBody = {}", messageBody);
        resWriter.write("ok");
    }
    // Http header, body 정보 조회
    @PostMapping("/requestbody3")
    public HttpEntity<String> requestBody3(HttpEntity<String> httpEntity) throws IOException {
        String messageBody = httpEntity.getBody();
        log.info("msgBody = {}", messageBody);
        return new HttpEntity<>("ok");
    }

    @ResponseBody
    @PostMapping("/requestbody4")
    public String requestBody4 (@RequestBody String messageBody) throws IOException {
        log.info("msgBody = {}", messageBody);
        return "ok";
    }
}

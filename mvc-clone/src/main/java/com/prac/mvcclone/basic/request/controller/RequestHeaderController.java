package com.prac.mvcclone.basic.request.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest req,
                          HttpServletResponse res,
                          HttpMethod httpMethod,
                          Locale locale,
                          // MultiValueMap 하나의 키에 여러 값 리스트로 가능
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value="mycookie", required = false) String cookie) {
        log.info("request={}", req);
        log.info("response={}", res);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale); // ko_KR
        log.info("headerMap={}", headerMap); // content-Type, user-agent
        log.info("header host={}", host); // localhost:8080
        log.info("mycookie={}", cookie);

        return "ok";
    }
}

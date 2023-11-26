package com.prac.mvcclone.basic.response.controller;

import com.prac.mvcclone.basic.HelloData;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class ResponseBodyController {
    @GetMapping("/responsebody-view1")
    public void responseBody1(HttpServletResponse res) throws IOException {
        res.getWriter().write("ok");
    }

    @GetMapping("/responsebody-view2")
    public ResponseEntity<String> responseBody2() throws IOException {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/responsebody-view3")
    public String resopnseBody3(HttpServletResponse res) {
        return "ok";
    }

    @GetMapping("/responsebody-json1")
    public ResponseEntity<HelloData> responsebodyJson1() {
        HelloData helloData = new HelloData("Lee", 25);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)	// 어노테이션을 사용해 HttpStatus 변경
    @GetMapping("/response-body-json-v2")
    public HelloData responsebodyJson2 () {
        HelloData helloData = new HelloData("Lee", 25);
        return helloData;
    }
}


package com.prac.mvcclone.basic.request.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prac.mvcclone.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

// Post 메세지 바디에 String 데이터 담아서 전송
// Json은 매핑이 가능해서 객체 생성해서 전송

@WebServlet(name="requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {

//        ServletInputStream stream = req.getInputStream();
//        String msgBody = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
//        System.out.println("msg Body = " + msgBody);
//        res.getWriter().write("ok");

        ServletInputStream stream = req.getInputStream();
        String msgBody = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
        System.out.println("msg Body = " + msgBody);

        HelloData helloData = mapper.readValue(msgBody, HelloData.class);
        System.out.println(helloData.getAge());
        System.out.println(helloData.getUsername());

        res.getWriter().write("ok");
    }
}


//        ServletInputStream stream = req.getInputStream();
//        String msgBody = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
//        System.out.println("msg Body = " + msgBody);
//        res.getWriter().write("ok");
package com.prac.mvcclone.basic.request.servlet;

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

@WebServlet(name="requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {
        ServletInputStream stream = req.getInputStream();
        String msgBody = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
        System.out.println("msg Body = " + msgBody);
        res.getWriter().write("ok");
    }
}

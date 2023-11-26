package com.prac.mvcclone.basic.response.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prac.mvcclone.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    // HttpServletResponse는 http 응답, 헤더, 바디 생성 / Content-Type, cookie,redirect 기능
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // status-line
        res.setStatus(HttpServletResponse.SC_OK);

        // header
        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");

        res.setHeader("Cache-Contorl", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("temp-header", "hello world");

//        PrintWriter writer = res.getWriter();
//        writer.println("<html>");
//        writer.println("<body>");
//        writer.println(" <div>msg here</div>");
//        writer.println("</body>");
//        writer.println("</html>");

        cookie(res);
        redirect(res);
        PrintWriter writer = res.getWriter();
        writer.println("ok");
    }

//    private ObjectMapper mapper = new ObjectMapper();
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//        res.setContentType("application/json");
//        res.setCharacterEncoding("utf-8");
//
//        // HelloData 객체
//        HelloData helloData = new HelloData();
//        helloData.setUsername("yeonlog");
//        helloData.setAge(25);
//
//        // json 형태로 바꾸기
//        String result = mapper.writeValueAsString(helloData);
//        res.getWriter().write(result);
//    }

    private void cookie(HttpServletResponse res) {
        Cookie cookie = new Cookie("MyCookie", "good");
        cookie.setMaxAge(60);
        res.addCookie(cookie);
    }

    private void redirect(HttpServletResponse res) {
        res.setStatus(HttpServletResponse.SC_FOUND);
        res.setHeader("Location", "/basic/hello-form.html");
    }

}
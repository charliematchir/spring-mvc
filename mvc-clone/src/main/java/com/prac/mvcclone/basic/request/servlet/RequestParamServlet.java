package com.prac.mvcclone.basic.request.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// post로 요청

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param-test")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {
        System.out.println("[전체 파라미터 조회]");
        req.getParameterNames().asIterator()
                .forEachRemaining(paramNames -> System.out.println(paramNames + " = " +
                        req.getParameter(paramNames)));
        System.out.println("[전체 파라미터 조회]");

        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println(username + age);
        System.out.println("[단일 파라미터 조회]");

        System.out.println("[복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username");
        for(String name:usernames)  {
            System.out.println(name);
        }
        System.out.println("[복수 파라미터 조회]");

        res.getWriter().write("ok");
    }
}

// http://localhost:8080/request-param?username=yeonlog&age=25

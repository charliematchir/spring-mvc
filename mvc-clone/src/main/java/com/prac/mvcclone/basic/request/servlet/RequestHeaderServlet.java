package com.prac.mvcclone.basic.request.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) {
        printStartLine(req);
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " 		+ request.getMethod()); 	//GET
        System.out.println("request.getProtocal() = " 		+ request.getProtocol()); 	//HTTP/1.1
        System.out.println("request.getScheme() = " 		+ request.getScheme()); 	//http

        // localhost:8080/request-header
        System.out.println("request.getRequestURL() = " 	+ request.getRequestURL());

        // /request-test
        System.out.println("request.getRequestURI() = " 	+ request.getRequestURI());


        System.out.println("request.getQueryString() = " 	+ request.getQueryString()); // username
        System.out.println("request.isSecure() = " 		+ request.isSecure()); 		//https
        System.out.println("--- REQUEST-LINE - end ---");

    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- Headers - start ---");
        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": "+headerName));

        System.out.println("-Headers-end-");

    }


    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("-Header 편의 조회 start-");

        System.out.println("[Host 편의 조회]");
        System.out.println("req.getServerName() = " + req.getServerName());
        System.out.println("req.getServerPort() = " + req.getServerPort());


        System.out.println("[Accept Language 편의 조회]");
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +locale));
        System.out.println("req.getLocale() = " + req.getLocale());


        System.out.println("[cookie 편의 조회]");
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }

        System.out.println("[Content 편의 조회]");
        System.out.println("req.getContentType() = " + req.getContentType());
        System.out.println("req.getContentLength() = " + req.getContentLength());
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());

        System.out.println("--- Header 편의 조회 end ---");

    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("-기타 조회 start-");

        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());


        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("-기타 조회 end-");
    }
}
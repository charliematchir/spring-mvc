package com.prac.mvcclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MvcCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcCloneApplication.class, args);
    }

}

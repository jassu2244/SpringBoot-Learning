package com.telusko.SpringEcom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//is used to create RESTful web services. It tells Spring that the class will handle HTTP requests and that the
// return value of its methods should be sent directly as the HTTP response body (instead of rendering a view like JSP or Thymeleaf).
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet() {
        return "Hello";
    }

}

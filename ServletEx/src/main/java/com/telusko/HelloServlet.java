package com.telusko;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello") // this is the way when using external tomcat and not embedded
public class HelloServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("In service");
    }
}

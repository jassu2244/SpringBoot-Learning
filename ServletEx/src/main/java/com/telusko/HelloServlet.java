package com.telusko;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hello") // this is the way when using external tomcat and not embedded
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In service");

        res.setContentType("text/html"); // this line tells that we are sending html and not just simple text

        PrintWriter out = res.getWriter(); //creating an object to send output to web page
        out.println("<h2><b>Hello World</b></h2>");
    }
}

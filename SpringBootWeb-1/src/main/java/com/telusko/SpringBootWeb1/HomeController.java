package com.telusko.SpringBootWeb1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //this tells spring that this is servlet controller
public class HomeController {

    @RequestMapping("/") //this will work, but it will not show the output as by default it does not support jsp page
    //so we need tomcat jasper dependency to show jsp page in the browser
    public String home() {
        System.out.println("home method called");
        return "index.jsp"; //this will not work right now because browser don't know which method to call on which
        //request, So we need to first do Mapping
    }
}

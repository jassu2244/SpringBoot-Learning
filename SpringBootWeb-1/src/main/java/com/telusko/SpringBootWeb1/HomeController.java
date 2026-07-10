package com.telusko.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //this tells spring that this is servlet controller
public class HomeController {

    @RequestMapping("/") //this will work, but it will not show the output as by default it does not support jsp page
    //so we need tomcat jasper dependency to show jsp page in the browser
    public String home() {
        System.out.println("home method called");
        //return "index.jsp"; //this will not work right now because browser don't know which method to call on which
        //request, So we need to first do Mapping
        return "index"; //to pass it like this without extension we can use spring application properties(prefix and suffix)
    }

    @RequestMapping("add") //here we need to pass the url where we want to map
    //public String add(int num1, int num2, HttpSession session) { //when you pass the query parameter here with same name
        //it matches the variable name and pass the parameter to method

        //used RequestParam annotation to change variable name and make code more simple
//    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, HttpSession session) {

//    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {

    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv) {

//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;

//        session.setAttribute("result", result); // here we pass name and result
        mv.addObject("result", result); //using ModelAndView in place of Model to do the same
        mv.setViewName("result"); //we need to pass this to make it find this result.jsp page

//        return "result.jsp";
//        return "result";

        return mv; //using model and view we don't need to pass the result page like this
    }

    @RequestMapping("addAlien")
    public ModelAndView addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, ModelAndView mv) {
        Alien alien=new Alien();
        alien.setAid(aid);
        alien.setAname(aname);
        mv.addObject("alien",alien);
        mv.setViewName("result");
        return mv;
    }

}

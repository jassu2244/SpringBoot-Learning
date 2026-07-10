package com.telusko;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        //Mapping Part
        Context context = tomcat.addContext("", null);//to do the mapping we need to get the hold of context object
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet()); // context, name of servlet and servlet class
        context.addServletMappingDecoded("/hello", "HelloServlet"); //we need to mention same name as above servletNane

        //Starting the server
        tomcat.start(); // this is how we can make the tomcat run
        tomcat.getServer().await(); //this line is telling tomcat to wait
        // and not stop running, getServer means telling to hold the server
    }
}

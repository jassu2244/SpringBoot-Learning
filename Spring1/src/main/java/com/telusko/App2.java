package com.telusko;

import com.telusko.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Here we are using Java based configuration to talk to container
public class App2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Desktop dt = context.getBean("beast", Desktop.class);

        //after this we need to create bean of this class in AppConfig
        Alien obj1 = context.getBean(Alien.class);
        System.out.println(obj1.getAge());
        obj1.code(); //right now when we run this it will create an object of alien but gives an error because it has 2 things and
        //abhi we just defined age, we did nothing for com(computer object), so let's set this too using setCom()


//        Desktop dt = context.getBean(Desktop.class);
//        dt.compile();
//
//        Desktop dt1 = context.getBean(Desktop.class);
//        dt.compile();
    }
}

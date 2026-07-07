package com.telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        //In this application context line, object is being created only
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // this line will give me a container for spring
        Alien obj1 = (Alien) context.getBean("alien1"); //here we passed id of the bean so make sure it is same as of xml

        // so when we run this, even though obj1 and obj2 are 2 different references, but they are the same object


//        obj1.setAge(21);
        System.out.println(obj1.getAge());
        obj1.code();

        //when we run this, we can see object for this is not created again, we are getting one object only but when we set
        // the scope to prototype it will create 2 separate objects,
        // so before when we were running before the scope by default is singleton so
        // we only one object is created even after there were 2 different references


//        Alien obj2 = (Alien) context.getBean("alien1");
//        System.out.println(obj2.age);

//        obj2.code();
    }
}

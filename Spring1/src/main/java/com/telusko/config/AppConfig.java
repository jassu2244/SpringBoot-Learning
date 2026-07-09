package com.telusko.config;

import com.telusko.Alien;
import com.telusko.Computer;
import com.telusko.Desktop;
import com.telusko.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

//this annotation is required to configure java based app
@Configuration
@ComponentScan("com.telusko") // this annotation will scan the complete package, and it scans for
// @Component annotation in class and make it manage by spring, so we don't have to write all this code that
// is written here, so I am commenting it
public class AppConfig {

//    @Bean
//    public Alien alien(Computer com) { // (@Qualifier("desktop")) using this autowired(@Autowired) annotation is optional, it will still work in newer version
//        // so in Qualifier annotation we have to mention the name of method (bean), also we can also use Primary
//        Alien obj = new Alien();
//        obj.setAge(25);
//        obj.setCom(com);
//        //obj.setCom(desktop()); // this will remove the error, but it is tightly coupled right now, what if we have laptop, so in
//        //constructor just pass ((Computer com) a computer object)
//        return obj;
//    }
//
//    // this is executed by spring, this Bean annotation tells spring to create a bean like we are creating manually in XML
//    //name of your bean is by default the name that is of your method means like here it is desktop.
//    //also we can specify name using this tag too and give multiple words
////    @Bean(name = {"com2", "desktop1", "beast"})
//
//    @Bean
//    //@Scope("prototype") //this annotation is used to define scope like giving prototype rather than singleton
//    // so when we give prototype even for same class it will create multiple object rather than singleton where it uses same object
//    //to reference it even though we create multiple references
//    public Desktop desktop(){
//        return new Desktop();
//    }
//
//    // When we create this, it will give error found 2 bean, so to resolve this, we can use annotation @Qualifier(this is similar as ref of XML)
//    @Bean
//    @Primary
//    public Laptop laptop() {
//        return new Laptop();
//    }
}

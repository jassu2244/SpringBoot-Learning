package com.telusko.config;

import com.telusko.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//this annotation is required to configure java based app
@Configuration
public class AppConfig {

    // this is executed by spring, this Bean annotation tells spring to create a bean like we are creating manually in XML
    //name of your bean is by default the name that is of your method means like here it is desktop.
    //also we can specify name using this tag too and give multiple words
//    @Bean(name = {"com2", "desktop1", "beast"})

    @Bean
    @Scope("prototype") //this annotation is used to define scope like giving prototype rather than singleton
    // so when we give prototype even for same class it will create multiple object rather than singleton where it uses same object
    //to reference it even though we create multiple references
    public Desktop desktop(){
        return new Desktop();
    }

}

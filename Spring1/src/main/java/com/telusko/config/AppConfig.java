package com.telusko.config;

import com.telusko.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//this annotation is required to configure java based app
@Configuration
public class AppConfig {

    // this is executed by spring
    @Bean
    public Desktop desktop(){
        return new Desktop();
    }

}

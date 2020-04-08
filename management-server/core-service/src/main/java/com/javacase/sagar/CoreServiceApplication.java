package com.javacase.sagar;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CoreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreServiceApplication.class,args);
    }
}

@RestController
class HomeController{

    @GetMapping(path = "/user")
    public String helloUser(){
        return "Hello User...!!!";
    }

}

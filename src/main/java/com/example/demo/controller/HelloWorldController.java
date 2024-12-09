package com.example.demo.controller;

import com.example.demo.model.HelloWeb;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWeb helloWeb;

    @Autowired
    GreetingService greetingService;

    @GetMapping("hello")
    public String sayHello(){
        return greetingService.greet();
    }

    @GetMapping("helloweb")
    public HelloWeb sayHelloWebWithObject(){
        helloWeb.setId(1);
        helloWeb.setMessage("Hello Web!");
        return helloWeb;
    }
    //Accessing and using PATH Variable
    @GetMapping("/helloweb/name/{name}/{message}")
    public String sayHelloWithObjectPath(@PathVariable String name, @PathVariable String message){
        return "Hello " + name + " " +message;
    }
    //Accessing Query String /helloweb/agelink?age=25&gender=M
    @GetMapping("/helloweb/agelink")
    public  String sayHelloWithQueryString(@RequestParam String age, @RequestParam String gender){
        return "Hello, your age is  " +age +" " +gender;
    }
}

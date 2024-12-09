package com.example.demo.controller;

import com.example.demo.model.HelloWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWeb helloWeb;

    @GetMapping("hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("helloweb")
    public HelloWeb sayHelloWebWithObject(){
        helloWeb.setId(1);
        helloWeb.setMessage("Hello Web!");
        return helloWeb;
    }

    @GetMapping("/helloweb/name/{name}/{message}")
    public String sayHelloWithObjectPath(@PathVariable String name, @PathVariable String message){
        return "Hello " + name + " " +message;
    }


}

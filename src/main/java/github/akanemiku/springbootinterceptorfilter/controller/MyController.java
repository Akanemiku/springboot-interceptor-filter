package github.akanemiku.springbootinterceptorfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/hello")
    public String hello2(){
        return "hello world";
    }
}

package com.example.test.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/hello")
    public String test(){
        return "Hello, world!";
    }

}
/*------------------테스트를 위한 텍스트 입력-------------*/
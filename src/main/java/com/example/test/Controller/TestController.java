package com.example.test.Controller;

import com.example.test.service.TestService;
import com.example.test.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    private TestService testService;

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/tests")
    public TestEntity createTestEntity() {
        return testService.createTestEntityRecord();
    }
}
/*---------------------------------------------------테스트를 위한 텍스트 입력------------------------------------------------*/
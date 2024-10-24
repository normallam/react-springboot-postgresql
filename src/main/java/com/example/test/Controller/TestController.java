package com.example.test.Controller;

import com.example.test.dto.TestDto;
import com.example.test.service.TestService;
import com.example.test.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }

    // 프로젝트 정보 생성
    @PostMapping
    public ResponseEntity<TestEntity> createTestEntity(@RequestBody TestDto testDto) throws Exception {
        TestEntity createdEntity = testService.createTestEntity(testDto);
        return ResponseEntity.ok(createdEntity);
    }

    /*
    // 프로젝트 정보 생성
    @PostMapping
    public ResponseEntity<TestEntity> createTestEntity(@RequestBody TestEntity testEntity) {
        TestEntity createdEntity = testService.createTestEntity(testEntity);
        return ResponseEntity.ok(createdEntity);
    }
    */
    @GetMapping
    public List<TestEntity> getAllTestEntities() {
        return testService.getAllTestEntities();
    }
}

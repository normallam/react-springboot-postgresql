package com.example.test.service;

import com.example.test.dto.TestDto;
import com.example.test.entity.TestEntity;
import com.example.test.repostiory.TestRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;
    private final ObjectMapper objectMapper;

    // TempRepository를 주입받는 생성자
        @Autowired
        public TestService(TestRepository testRepository, ObjectMapper objectMapper) {
            this.testRepository = testRepository;
            this.objectMapper = objectMapper;
        }

    // TestDto를 받아 TestEntity로 변환 후 저장
    public TestEntity createTestEntity(TestDto testDto) throws Exception {
        TestEntity testEntity = new TestEntity();
        testEntity.setName(testDto.getName());
        testEntity.setDescription(testDto.getDescription());
        testEntity.setStart_date(Date.valueOf(testDto.getStart_date()));  // String -> Date
        testEntity.setEnd_date(Date.valueOf(testDto.getEnd_date()));
        testEntity.setBudget(testDto.getBudget());

        // JSON 문자열을 JsonNode로 변환하여 저장
        JsonNode teamMembersNode = testDto.getTeam_members();
        testEntity.setTeam_members(teamMembersNode);

        return testRepository.save(testEntity);
    }

    // 모든 프로젝트 정보 조회
    public List<TestEntity> getAllTestEntities(){
            return testRepository.findAll();
    }

        /* ------------------------2--------------------
        // 프로젝트 정보 생성
        public TestEntity createTestEntity(TestEntity testEntity){
            return testRepository.save(testEntity);
        }

        // 모든 프로젝트 정보 조회
        public List<TestEntity> getAllTestEntities(){
            return testRepository.findAll();
        }
        -----------------------------------------------*/

        /*-----------------------1--------------------
        // Temp 엔티티를 생성 후 confirm 필드를 true로 저장
        public TestEntity createTestEntityRecord() {
            TestEntity testentity = new TestEntity();
            testentity.setConfirm(true);
            return testRepository.save(testentity);
        }
         ---------------------------------------------*/
}

package com.example.test.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Data
@Table(name = "c_test")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;                // 프로젝트명
    private String description;         // 프로젝트 설명
    private java.sql.Date start_date;   // 프로젝트 시작 날짜
    private java.sql.Date end_date;     // 프로젝트 완료 날짜
    private java.math.BigDecimal budget; // 프로젝트 예산


    /*@Type(type = "com.example.test.type.JsonNodeType") // 사용자 정의 타입 지정
    private JsonNode team_members;
    */
    //@OneToMany(fetch = FetchType.LAZY,mappedBy = ) // 다른 엔티티에 연결하는 방법 고려
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private JsonNode team_members;         // 프로젝트 멤버 정보 (JSONB로 저장)

}

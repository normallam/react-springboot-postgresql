package com.example.test.dto;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TestDto {
    private String name;
    private String description;
    private String start_date;
    private String end_date;
    private BigDecimal budget;
    private JsonNode team_members;  // team_members를 JsonNode로 정의

}

package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class MaterialDTO {

    private Long id;

    private String name;

    private BigDecimal value;

    private LocalDate dateOfConclusion;

    // to be switched to Milestone object
    private String milestone;
}

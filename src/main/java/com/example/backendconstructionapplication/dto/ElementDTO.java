package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ElementDTO {

    private Long id;

    private String name;

    private String description;

    // to be switched to Status enum
    private String status;

    private LocalDate dateOfExecute;

    private Integer durationDay;

    // to be switched to Milestone object
    private String milestone;



}

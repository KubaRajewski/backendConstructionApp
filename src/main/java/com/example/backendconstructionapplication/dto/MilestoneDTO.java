package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MilestoneDTO {

    private Long id;

    private String name;

    // to be switched to Executor object
    private String executor;

    private LocalDate estimatedDateOfRealization;

    // to be switched to Document object
    private List<String> documents;

    // to be switched to Material object
    private List<String> material;

    // to be switched to Elements object
    private List<String> elements;


}

package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
public class DocumentDTO {

    private Long id;

    private String name;

    // to be switched to Enum Type
    private String type;

    private LocalDate dateOfIssue;

    // to be switched to User object
    private String sender;

    // to be switched to User object
    private List<String> recipients;

    // to be switched to Milestone object
    private String milestone;


}

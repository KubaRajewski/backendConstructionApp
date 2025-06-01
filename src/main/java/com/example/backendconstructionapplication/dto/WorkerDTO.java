package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerDTO {

    private Long id;

    private String firstName;

    private String lastName;

    // to be switched to Enum type
    private String specialization;

    // to be switched to Construction object
    private String construction;

    // to be switched to Milestone object
    private String milestone;

    // to be switched to Team object
    private String team;

}

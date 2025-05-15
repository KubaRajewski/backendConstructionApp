package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContractorDTO {

    private Long id;

    private String companyName;

    private Integer numberOfEmployees;

    // to be switched to Construction object
    private String construction;

    // to be switched to Contract object
    private String contract;

}

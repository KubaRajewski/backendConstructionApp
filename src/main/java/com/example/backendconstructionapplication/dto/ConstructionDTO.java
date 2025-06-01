package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ConstructionDTO {

    private Long id;

    private String name;

    private String location;

    private BigDecimal estimatedCostOfRealization;

    private Double percentOfRealization;

    private BigDecimal currentCost;

    //to be switched to Contractor object
    private List<String> contractors;

    // to be switched to Team object
    private List<String> teams;

    // to be switched to Milestone object
    private List<String> milestones;

    // to be switched to Project object
    private String project;
}

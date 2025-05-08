package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProjectDTO {

    private Long id;

    private String name;

    private long plannedPrizeOfRealization;

    private double percentOfRealization;

    private long currentCostOfRealization;

    private String location;

    // to be switched to Material object
    private List<String> materials;

    // to be switched to Contractors object
    private List<String> contractors ;

    // to be switched to ProjectMenager object
    private String projectManager;

    // to be switched to milestones object
    private List<String> milestones;

}

package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TeamDTO {

    private Long id;

    private String name;

    // to be switched to  object
    private List<String> workers;

    // to be switched to Contractors object
    private List<String> users;

    private String construction;

}

package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Issue extends DocumentDTO {

    private String description;

}

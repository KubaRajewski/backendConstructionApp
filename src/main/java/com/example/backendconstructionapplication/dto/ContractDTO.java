package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


// This class mays extends or not necessary
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ContractDTO extends DocumentDTO{

    private BigDecimal value;

    private String client;

    // to be switched to Contractor object
    private String contractor;

}

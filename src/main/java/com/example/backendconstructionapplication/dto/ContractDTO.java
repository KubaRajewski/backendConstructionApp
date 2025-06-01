package com.example.backendconstructionapplication.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


// This class mays extends or not necessary
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class ContractDTO extends DocumentDTO{

    private BigDecimal value;

    private String client;

    // to be switched to Contractor object
    private String contractor;

}

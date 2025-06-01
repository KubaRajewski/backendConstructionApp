package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class InvoiceDTO extends DocumentDTO{

    private BigDecimal value;

    private String client;
}

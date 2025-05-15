package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Report extends DocumentDTO {

    // it seems like Kanban dashboard
    private List<String> toDo;

    private List<String> isDoing;

    private List<String> isDone;


}

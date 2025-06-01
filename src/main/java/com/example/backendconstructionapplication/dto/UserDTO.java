package com.example.backendconstructionapplication.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class UserDTO {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    // to be switched to Enum type
    private String roleInTheCompany;

    // to be switched to Team object
    private String team;
}

package com.polaristech.bookassignment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AuthorDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private Date dateCreated;
    private Date modified;
}

package com.polaristech.bookassignment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    UUID id;
    private String title;
    private String isbn;
    private UUID authorId;
    private UUID publisherId;
    private String gender;
    private UUID countryId;
    private Date dateCreated;
    private Date dateModified;
}

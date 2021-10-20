package com.polaristech.bookassignment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    UUID id;
    private String countryName;
    private String countryCode;
    private String countryShortCode;
    private Date dateCreated;
    private Date dateModified;
    private UUID modifiedBy;
}

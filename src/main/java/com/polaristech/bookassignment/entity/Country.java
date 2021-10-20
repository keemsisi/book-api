package com.polaristech.bookassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Country {
    @Id
    private UUID id;
    @NotNull
    @Column
    private String countryName;
    @NotNull
    @Column
    private String shortName;
    @NotNull
    @Column
    private String extension;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    @NotNull
    private Date dateCreated;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Date dateModified;
}

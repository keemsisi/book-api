package com.polaristech.bookassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;

@Entity
public class Publisher {
    @Id
    private UUID id;
    @Column
    private String publisherName;
    @NotNull
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    Date dateCreated;
    @Column(columnDefinition = "TIMESTAMP WITH TIMEZONE DEFAULT NULL")
    Date dateModified;
    @NotNull
    private UUID createdBy;
}

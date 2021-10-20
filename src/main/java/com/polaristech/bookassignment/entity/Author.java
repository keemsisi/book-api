package com.polaristech.bookassignment.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    private UUID id;
    @Column
    private String firstName;
    @Column String lastName;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateModified;
    @Column
    private UUID createdBy;
}

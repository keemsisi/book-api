package com.polaristech.bookassignment.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    private UUID id;
    @Column
    private String title;
    @Column
    private Author author;
    @NotNull
    @Column
    private Publisher publisher;
    @NotNull
    private String isbn;
    @NotNull
    @Column
    private Country country;
    @Column
    private String gender;
    @Column
    private UUID createdBy;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private Date dateCreated;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Date dateModified;
}

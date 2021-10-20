package com.polaristech.bookassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "publisher")
@Table(name = "publisher")
public class Publisher {
    @NotNull
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    Date dateCreated;
    @Column(columnDefinition = "TIMESTAMP WITH TIMEZONE DEFAULT NULL")
    Date dateModified;
    @Id
    private UUID id;
    @Column
    private String publisherName;
    @NotNull
    private UUID createdBy;
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<Book> books;
}

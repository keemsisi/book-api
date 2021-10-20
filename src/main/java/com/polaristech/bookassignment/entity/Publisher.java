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
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    private UUID id;
    @Column
    private String publisherName;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    Date dateCreated;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NULL")
    Date dateModified;
    @NotNull
    private UUID createdBy;
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<Book> books;
}
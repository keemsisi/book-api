package com.polaristech.bookassignment.common.dto;

import com.polaristech.bookassignment.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
    private UUID id;
    @NotEmpty
    private String publisherName;
    private Date dateCreated;
    private Date dateModified;
    private List<BookDTO> books;
}

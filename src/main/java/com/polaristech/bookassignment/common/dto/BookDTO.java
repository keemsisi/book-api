package com.polaristech.bookassignment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    UUID id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String title;
    @NotNull
    @NotBlank
    @NotEmpty
    private String isbn;
    @NotNull
    @NotBlank
    @NotEmpty
    private UUID authorId;
    @NotNull
    @NotBlank
    @NotEmpty
    private UUID publisherId;
    @NotNull
    @NotBlank
    @NotEmpty
    private String gender;
    @NotNull
    @NotBlank
    @NotEmpty
    private UUID countryId;
    private Date dateCreated;
    private Date dateModified;
}

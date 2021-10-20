package com.polaristech.bookassignment.api;


import com.polaristech.bookassignment.common.dto.AuthorDTO;
import com.polaristech.bookassignment.entity.Author;

import java.util.Optional;
import java.util.UUID;

public interface IAuthor {
    Optional<Author> getAuthor(UUID uuid);

    UUID createAuthor(AuthorDTO uuid);
}

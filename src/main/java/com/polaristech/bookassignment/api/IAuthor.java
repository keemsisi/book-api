package com.polaristech.bookassignment.api;


import com.polaristech.bookassignment.common.dto.AuthorDTO;
import com.polaristech.bookassignment.entity.Author;

import java.util.UUID;

public interface IAuthor {
    Author getAuthor(UUID uuid);

    UUID createAuthor(AuthorDTO uuid);
}

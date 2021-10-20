package com.polaristech.bookassignment.service;

import com.polaristech.bookassignment.api.IAuthor;
import com.polaristech.bookassignment.common.dto.AuthorDTO;
import com.polaristech.bookassignment.entity.Author;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class AuthorService implements IAuthor {
    @Override
    public Optional<Author> getAuthor(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public UUID createAuthor(AuthorDTO uuid) {
        return null;
    }
}

package com.polaristech.bookassignment.service;

import com.polaristech.bookassignment.api.IAuthor;
import com.polaristech.bookassignment.common.dto.AuthorDTO;
import com.polaristech.bookassignment.entity.Author;
import com.polaristech.bookassignment.exceptions.ResourceNotFoundException;
import com.polaristech.bookassignment.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class AuthorService implements IAuthor {
    @Autowired
    private final AuthorRepository authorRepository;

    @Override
    public Author getAuthor(UUID uuid) {
        Optional<Author> book = authorRepository.findById(uuid);
        if (book.isEmpty()) throw new ResourceNotFoundException(String.format("author with id[%s] not found", uuid));
        return authorRepository.getById(uuid);
    }

    @Override
    public UUID createAuthor(AuthorDTO authorDTO) {
        Author author =  Author.builder()
                .id(UUID.randomUUID())
                .dateCreated(new Date())
                .firstName(authorDTO.getFirstName())
                .lastName(authorDTO.getLastName())
                .createdBy(UUID.randomUUID())
                .dateModified(null)
                .build();
        return authorRepository.save(author).getId();
    }
}

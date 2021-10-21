package com.polaristech.bookassignment.service;

import com.polaristech.bookassignment.api.IPublisher;
import com.polaristech.bookassignment.common.dto.PublisherDTO;
import com.polaristech.bookassignment.entity.Publisher;
import com.polaristech.bookassignment.exceptions.ResourceNotFoundException;
import com.polaristech.bookassignment.repository.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class PublisherService implements IPublisher {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher getPublisher(UUID id) {
        Optional<Publisher> book = publisherRepository.findById(id);
        if (book.isEmpty()) throw new ResourceNotFoundException(String.format("publisher with id %s not found", id));
        return publisherRepository.getById(id);
    }

    @Override
    public UUID createPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = Publisher.builder()
                .id(UUID.randomUUID())
                .dateCreated(new Date())
                .publisherName(publisherDTO.getPublisherName())
                .createdBy(UUID.randomUUID())
                .dateModified(null)
                .build();
        return publisherRepository.save(publisher).getId();
    }
}

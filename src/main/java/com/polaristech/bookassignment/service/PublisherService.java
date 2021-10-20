package com.polaristech.bookassignment.service;

import com.polaristech.bookassignment.api.IPublisher;
import com.polaristech.bookassignment.common.dto.PublisherDTO;
import com.polaristech.bookassignment.entity.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class PublisherService implements IPublisher {
    @Override
    public Optional<Publisher> getPublisher(UUID publisher) {
        return Optional.empty();
    }

    @Override
    public UUID createPublisher(PublisherDTO publisher) {
        return null;
    }
}

package com.polaristech.bookassignment.api;

import com.polaristech.bookassignment.common.dto.PublisherDTO;
import com.polaristech.bookassignment.entity.Publisher;

import java.util.Optional;
import java.util.UUID;

public interface IPublisher {
    Optional<Publisher> getPublisher(UUID publisher);

    UUID createPublisher(PublisherDTO publisher);
}

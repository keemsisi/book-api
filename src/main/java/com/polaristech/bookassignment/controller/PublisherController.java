package com.polaristech.bookassignment.controller;

import com.polaristech.bookassignment.api.IPublisher;
import com.polaristech.bookassignment.common.GenericResponse;
import com.polaristech.bookassignment.common.dto.AuthorDTO;
import com.polaristech.bookassignment.common.dto.PublisherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/book/publisher")
public class PublisherController {
    @Autowired
    private IPublisher iPublisher;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "")
    public ResponseEntity<GenericResponse<?>> createPublisher(@NotNull @RequestBody PublisherDTO authorDTO) {
        return ResponseEntity.ok().body(new
                GenericResponse<>(
                "00",
                "Publisher created successfully",
                iPublisher.createPublisher(authorDTO),
                new Date())
        );
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/search/{id}")
    public ResponseEntity<GenericResponse<?>> getPublisher(@NotNull @PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(new
                GenericResponse<>(
                "00",
                "Response was successful",
                iPublisher.getPublisher(id),
                new Date())
        );
    }
}

package com.polaristech.bookassignment.controller;

import com.polaristech.bookassignment.api.IAuthor;
import com.polaristech.bookassignment.common.GenericResponse;
import com.polaristech.bookassignment.common.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/book/author")
public class AuthorController {
    @Autowired
    private IAuthor iAuthor;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "")
    public ResponseEntity<GenericResponse<?>> createAuthor(@NotNull @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok().body(new
                GenericResponse<>(
                "00",
                "Author created successfully",
                iAuthor.createAuthor(authorDTO),
                new Date())
        );
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/search/{id}")
    public ResponseEntity<GenericResponse<?>> getAuthor(@NotNull @PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(new
                GenericResponse<>(
                "00",
                "Response was successful",
                iAuthor.getAuthor(id),
                new Date())
        );
    }
}

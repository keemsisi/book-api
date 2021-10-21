package com.polaristech.bookassignment.controller;

import com.polaristech.bookassignment.api.IBook;
import com.polaristech.bookassignment.common.GenericResponse;
import com.polaristech.bookassignment.common.dto.BookDTO;
import com.polaristech.bookassignment.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    private IBook iBook;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/")
    public ResponseEntity<GenericResponse<?>> createBook(@NotNull @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(new
                GenericResponse<>(
                "00",
                "Request processed successfully",
                iBook.createBook(bookDTO),
                new Date())
        );
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/search/{id}")
    public ResponseEntity<GenericResponse<?>> getBook(@NotNull @PathVariable(value = "id") UUID bookId) {
        return ResponseEntity.ok().body(new
                GenericResponse<>(
                "00",
                "Request processed successfully",
                iBook.getBook(bookId),
                new Date())
        );
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "")
    public ResponseEntity<GenericResponse<?>> updateBook(@NotNull @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(new
                GenericResponse<>(
                "00",
                "Request processed successfully",
                iBook.editBook(bookDTO),
                new Date())
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/remove/{id}")
    public ResponseEntity<GenericResponse<?>> deleteBook(@NotNull @NotEmpty @PathVariable(value = "id") UUID bookId) {
        iBook.deleteBook(bookId);
        return ResponseEntity.ok().body(new
                GenericResponse<>(
                "00",
                "Request processed successfully",
                null,
                new Date())
        );
    }
}

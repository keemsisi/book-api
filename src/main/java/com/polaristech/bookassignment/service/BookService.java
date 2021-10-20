package com.polaristech.bookassignment.service;

import com.polaristech.bookassignment.api.IBook;
import com.polaristech.bookassignment.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Slf4j
@Service
public class BookService implements IBook {

    @Override
    public UUID createBook(@NotNull Book book) {
        return null;
    }

    @Override
    public boolean editBook(@NotNull Book book) {
        return false;
    }

    @Override
    public void deleteBook(@NotNull UUID uuid) {

    }

    @Override
    public Book getBook(@NotNull UUID uuid) {
        return null;
    }
}
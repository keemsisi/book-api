package com.polaristech.bookassignment.api;


import com.polaristech.bookassignment.entity.Book;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface IBook {
    UUID createBook(@NotNull Book book);

    boolean editBook(@NotNull Book book);

    void deleteBook(@NotNull UUID uuid);

    Book getBook(@NotNull UUID uuid);
}

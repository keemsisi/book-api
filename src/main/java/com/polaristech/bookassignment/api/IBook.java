package com.polaristech.bookassignment.api;


import com.polaristech.bookassignment.common.dto.BookDTO;
import com.polaristech.bookassignment.entity.Book;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public interface IBook {
    UUID createBook(@NotNull BookDTO book);

    Book editBook(@NotNull BookDTO bookDTO);

    void deleteBook(@NotNull UUID uuid);

    Book getBook(@NotNull UUID uuid);

    List<Book> getAll();
}

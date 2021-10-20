package com.polaristech.bookassignment.service;

import com.polaristech.bookassignment.api.IAuthor;
import com.polaristech.bookassignment.api.IBook;
import com.polaristech.bookassignment.api.ICountry;
import com.polaristech.bookassignment.api.IPublisher;
import com.polaristech.bookassignment.common.dto.BookDTO;
import com.polaristech.bookassignment.entity.Author;
import com.polaristech.bookassignment.entity.Book;
import com.polaristech.bookassignment.entity.Country;
import com.polaristech.bookassignment.entity.Publisher;
import com.polaristech.bookassignment.exceptions.ResourceNotFoundException;
import com.polaristech.bookassignment.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class BookService implements IBook {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private IAuthor iAuthor;
    @Autowired
    private IPublisher iPublisher;
    @Autowired
    private ICountry iCountry;

    @Override
    public UUID createBook(@NotNull BookDTO bookDTO) {
        UUID randomCreatedBy = UUID.randomUUID();
        Optional<Author> author = iAuthor.getAuthor(bookDTO.getAuthorId());
        if (author.isEmpty())
            throw new ResourceNotFoundException("author not found");
        Optional<Publisher> publisher = iPublisher.getPublisher(bookDTO.getPublisherId());
        if (publisher.isEmpty())
            throw new ResourceNotFoundException("publisher not found");
        Optional<Country> country = iCountry.getCountry(bookDTO.getCountryId());
        if (country.isEmpty())
            throw new ResourceNotFoundException("country not found");
        Book book = Book.builder()
                .author(List.of(author.get()))
                .publisher(publisher.get())
                .countryId(bookDTO.getCountryId())
                .gender(bookDTO.getGender())
                .isbn(bookDTO.getIsbn())
                .title(bookDTO.getTitle())
                .createdBy(randomCreatedBy)
                .build();
        bookRepository.save(book);
        return book.getId();
    }


    @Override
    public boolean editBook(@NotNull Book book) {
        Book updatedBook = getBook(book.getId());
        updatedBook.setGender(book.getGender());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setIsbn(book.getIsbn());
        updatedBook.setGender(book.getGender());
        bookRepository.save(updatedBook);
        return true;
    }

    @Override
    public boolean deleteBook(UUID uuid) {
        bookRepository.deleteById(getBook(uuid).getId());
        return true;
    }

    @Override
    public Book getBook(@NotNull UUID uuid) {
        Optional<Book> book = bookRepository.findById(uuid);
        if (book.isEmpty()) throw new ResourceNotFoundException(String.format("book with id %s not found", uuid));
        return bookRepository.getById(uuid);
    }
}
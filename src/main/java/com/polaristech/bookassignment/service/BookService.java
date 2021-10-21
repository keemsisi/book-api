package com.polaristech.bookassignment.service;

import com.polaristech.bookassignment.api.IAuthor;
import com.polaristech.bookassignment.api.IBook;
import com.polaristech.bookassignment.api.ICountry;
import com.polaristech.bookassignment.api.IPublisher;
import com.polaristech.bookassignment.common.dto.BookDTO;
import com.polaristech.bookassignment.entity.Author;
import com.polaristech.bookassignment.entity.Book;
import com.polaristech.bookassignment.entity.Publisher;
import com.polaristech.bookassignment.exceptions.ResourceNotFoundException;
import com.polaristech.bookassignment.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
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
        Optional<Author> author = Optional.ofNullable(iAuthor.getAuthor(bookDTO.getAuthorId()));
        if (author.isEmpty())
            throw new ResourceNotFoundException("author not found");
        Optional<Publisher> publisher = Optional.ofNullable(iPublisher.getPublisher(bookDTO.getPublisherId()));
        if (publisher.isEmpty())
            throw new ResourceNotFoundException("publisher not found");
//        Optional<Country> country = iCountry.getCountry(bookDTO.getCountryId());
//        if (country.isEmpty())
//            throw new ResourceNotFoundException("country not found");
        Book book = Book.builder()
                .id(UUID.randomUUID())
                .author(List.of(author.get()))
                .publisher(publisher.get())
                .countryId(UUID.randomUUID()) // random country
                .gender(bookDTO.getGender())
                .isbn(bookDTO.getIsbn())
                .title(bookDTO.getTitle())
                .createdBy(randomCreatedBy)
                .dateCreated(new Date())
                .build();
        return bookRepository.save(book).getId();
    }


    @Override
    public Book editBook(@NotNull BookDTO book) {
        Book updatedBook = getBook(book.getId());
        updatedBook.setGender(book.getGender());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setIsbn(book.getIsbn());
        updatedBook.setDateModified(new Date());
        updatedBook.setModifiedBy(UUID.randomUUID());
        updatedBook.setGender(book.getGender());
       return bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBook(UUID uuid) {
        bookRepository.deleteById(getBook(uuid).getId());
    }

    @Override
    public Book getBook(@NotNull UUID uuid) {
        Optional<Book> optionalBook = bookRepository.findById(uuid);
        if (optionalBook.isEmpty()) throw new ResourceNotFoundException(String.format("book with id %s not found", uuid));
        return optionalBook.get();
    }

    @Override
    public List<Book> getAll() {
        System.out.println(bookRepository.findAll(Sort.by(Sort.Direction.DESC, "dateCreated")).size());
        return bookRepository.findAll();
    }

}
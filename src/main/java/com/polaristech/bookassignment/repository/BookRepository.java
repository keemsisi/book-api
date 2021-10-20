package com.polaristech.bookassignment.repository;

import com.polaristech.bookassignment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, UUID>, PagingAndSortingRepository<Book, UUID> {
    Optional<Book> findById(UUID id);
}

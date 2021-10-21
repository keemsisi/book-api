package com.polaristech.bookassignment.repository;

import com.polaristech.bookassignment.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID>, PagingAndSortingRepository<Author, UUID> {
    Optional<Author> findById(UUID id);
}

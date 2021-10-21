package com.polaristech.bookassignment.repository;

import com.polaristech.bookassignment.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, UUID>, PagingAndSortingRepository<Country, UUID> {
    Optional<Country> findById(UUID id);
}
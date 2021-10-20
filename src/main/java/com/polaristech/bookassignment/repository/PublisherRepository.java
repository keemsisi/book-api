package com.polaristech.bookassignment.repository;

import com.polaristech.bookassignment.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface PublisherRepository extends JpaRepository<Publisher, UUID>, PagingAndSortingRepository<Publisher,UUID> {

}

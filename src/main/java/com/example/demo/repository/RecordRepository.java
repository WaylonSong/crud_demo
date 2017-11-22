package com.example.demo.repository;

/**
 * Created by song on 2017/10/23.
 */

import com.example.demo.model.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
//http://127.0.0.1:8083/api/records/search
public interface RecordRepository extends PagingAndSortingRepository<Record, Long> {
    //ok
    @PostAuthorize("hasRole('ROLE_ADMIN') or returnObject?.owner?.username == authentication?.name")
    public Record findOne(@Param("id") Long id);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Query("select r from Record r where r.owner.username = ?#{principal.emailAddress}")
    Page<Record> findAllRecords(Pageable pageable);
}


/*
reference:

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query(value = "select r from Record r where r.owner.username = 'swl2'")
    Page<Record> findAll(Pageable pageable);

    @Query(value = "select r from Record r where r.owner.username = ?1 and r.description='1111'")
*/
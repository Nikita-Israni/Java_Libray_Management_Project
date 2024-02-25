package com.libraryManagment.demo.repository;

import com.libraryManagment.demo.entity.BookEntity;
import com.libraryManagment.demo.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {

    List<Members> findByName(String name);

    List<Members> findByjoiningyearAfter(Integer year);
}

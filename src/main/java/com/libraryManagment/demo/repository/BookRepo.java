package com.libraryManagment.demo.repository;



import com.libraryManagment.demo.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

    List<BookEntity> findByGenre(String genre);

    List<BookEntity> findByAuthor(String genre);

    List<BookEntity> findBypublisheyearBetween(Integer start,Integer end);

    List<BookEntity> findByGenreAndLanguage(String genre,String language);

    List<BookEntity> findByPagesLessThan(Integer pages);

    List<BookEntity> findByPriceBetween(Integer startPrice,Integer endPrice);

    List<BookEntity> findBypublisheyear(Integer year);

}

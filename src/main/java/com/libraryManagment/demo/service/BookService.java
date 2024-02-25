package com.libraryManagment.demo.service;



import com.libraryManagment.demo.DTO.BookDto;
import com.libraryManagment.demo.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BookService {
public  String  save(BookDto BookDto);

    public BookEntity findByBookId(Integer bookId);

    public List<BookEntity> findBookByGenre(String genre);

    public List<BookEntity> findBookByAuthor(String genre);

    public List<BookEntity> findBookByRange(Integer start, Integer end);


    public List<BookEntity> findByGenreAndLanguage(String genre, String language);

    public List<BookEntity> findByPagesLess(Integer pages);

    public List<BookEntity> findBookByPriceRange(Integer start, Integer end);

    public List<BookEntity> findBookByPublishYear(Integer year);

    public String deleteBoookById(Integer id);

    public String uodateBookprice(Integer id,Integer price);

}

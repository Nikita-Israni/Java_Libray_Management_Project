package com.libraryManagment.demo.service.impl;


import com.libraryManagment.demo.DTO.BookDto;


import com.libraryManagment.demo.entity.BookEntity;
import com.libraryManagment.demo.repository.BookRepo;
import com.libraryManagment.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepo booksRepository ;


	@Override
	public String save(BookDto bookDto) {
		try
		{
			System.out.println("Inside method");
			BookEntity book = new BookEntity();
			book.setIsbn(bookDto.getIsbn());
			book.setTitle(bookDto.getTitle());
			book.setAuthor(bookDto.getAuthor());
			book.setPublisher(bookDto.getPublisher());
			book.setPublisheyear(bookDto.getYear());
			book.setGenre(bookDto.getGenre());
			book.setDescription(bookDto.getDescription());
			book.setPages(bookDto.getPages());
			book.setPrice(bookDto.getPrice());
			book.setLanguage(bookDto.getLanguage());
			booksRepository.save(book);
			return "save successfully";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

	@Override
	public BookEntity findByBookId(Integer bookId) {
		Optional<BookEntity> book = null;
		try
		{
			book =	booksRepository.findById(bookId);
		}
		catch(Exception e)
		{
		}
		return book.get();
	}

	@Override
	public List<BookEntity> findBookByGenre(String genre) {
		List<BookEntity>  book = null;
		try
		{
			book =	booksRepository.findByGenre(genre);
		}
		catch(Exception e)
		{
		}
		return book;
	}

	@Override
	public List<BookEntity> findBookByAuthor(String author) {
		List<BookEntity>  book = null;
		try
		{
			book =	booksRepository.findByAuthor(author);
		}
		catch(Exception e)
		{
		}
		return book;
	}

	@Override
	public List<BookEntity> findBookByRange(Integer start, Integer end) {
		List<BookEntity>  book = null;
		try
		{
			book =	booksRepository.findBypublisheyearBetween(start,end);
		}
		catch(Exception e)
		{
		}
		return book;
	}

	@Override
	public List<BookEntity> findByGenreAndLanguage(String genre, String language) {
		List<BookEntity>  book = null;
		try
		{
			book =	booksRepository.findByGenreAndLanguage(genre,language);
		}
		catch(Exception e)
		{
		}
		return book;
	}

	@Override
	public List<BookEntity> findByPagesLess(Integer pages) {
		List<BookEntity>  book = null;
		try
		{
			book =	booksRepository.findByPagesLessThan(pages);
		}
		catch(Exception e)
		{
		}
		return book;
	}

	@Override
	public List<BookEntity> findBookByPriceRange(Integer start, Integer end) {
		List<BookEntity>  book = null;
		try
		{
			book =	booksRepository.findByPriceBetween(start,end);
		}
		catch(Exception e)
		{
		}
		return book;
	}

	@Override
	public List<BookEntity> findBookByPublishYear(Integer year) {
		List<BookEntity>  book = null;
		try
		{
			book =	booksRepository.findBypublisheyear(year);
		}
		catch(Exception e)
		{
		}
		return book;
	}

	@Override
	public String deleteBoookById(Integer id) {
		try{
			Optional<BookEntity> book = booksRepository.findById(id);
			if(book.isPresent())
			{
				booksRepository.delete(book.get());
				return "Book Deleted Successfully";
			}
			else return "Invalid book Id";

		}catch(Exception e)
		{
			return "failed to delete book";
		}
	}

	@Override
	public String uodateBookprice(Integer id,Integer price) {
		try{
			Optional<BookEntity> book = booksRepository.findById(id);
			if(book.isPresent())
			{
				book.get().setPrice(price);
				booksRepository.save(book.get());
				return "Book price update Successfully";
			}
			else return "Invalid book Id";

		}catch(Exception e)
		{
			return "failed to update price of book";
		}
	}
}

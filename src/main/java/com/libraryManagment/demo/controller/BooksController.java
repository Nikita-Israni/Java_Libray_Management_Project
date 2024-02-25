package com.libraryManagment.demo.controller;


import com.libraryManagment.demo.DTO.APIResponseDTO;
import com.libraryManagment.demo.DTO.BookDto;
import com.libraryManagment.demo.entity.BookEntity;
import com.libraryManagment.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;


@Controller
@RequestMapping("/books")
public class BooksController {
	@Autowired
	BookService bookService;

		@PostMapping(value = "/save_book")
		    public ResponseEntity<APIResponseDTO> saveBook(@RequestBody BookDto booksDTO) {
			APIResponseDTO response = new APIResponseDTO();
		        try {
		        	String message = bookService.save(booksDTO);
					response.setMessage(message);
					response.setStatus(200);

		        } catch (Exception exception) {
					response.setMessage("Failed To save");
					response.setStatus(400);
		        }
			return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_book")
	public ResponseEntity<APIResponseDTO> getBook(@RequestHeader Integer bookId) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			BookEntity book = bookService.findByBookId(bookId);
			if (!book.equals(null)) {

				response.setMessage("Book SuccessFully Find");
				response.setBody(book);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_book_genre")
	public ResponseEntity<APIResponseDTO> findByGenre(@RequestHeader String genre) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<BookEntity> book = bookService.findBookByGenre(genre);
			if (!book.equals(null)&&!book.isEmpty()) {

				response.setMessage("Book SuccessFully Find");
				response.setBody(book);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(book);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_book_author")
	public ResponseEntity<APIResponseDTO> findByAuthor(@RequestHeader String author) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<BookEntity> book = bookService.findBookByAuthor(author);
			if (!book.equals(null)&&!book.isEmpty()) {

				response.setMessage("Book SuccessFully Find");
				response.setBody(book);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(null);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_book_year_range")
	public ResponseEntity<APIResponseDTO> findByYearRange(@RequestHeader Integer start,@RequestHeader Integer end) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<BookEntity> book = bookService.findBookByRange(start,end);
			if (!book.equals(null)&&!book.isEmpty()) {

				response.setMessage("Book SuccessFully Find");
				response.setBody(book);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(book);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_book_genre_langague")
	public ResponseEntity<APIResponseDTO> findByYearRange(@RequestHeader String genre,@RequestHeader String language) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<BookEntity> book = bookService.findByGenreAndLanguage(genre,language);
			if (!book.equals(null)&&!book.isEmpty()) {

				response.setMessage("Book SuccessFully Find");
				response.setBody(book);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(book);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_book_pages_less")
	public ResponseEntity<APIResponseDTO> findByloages(@RequestHeader Integer pages) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<BookEntity> book = bookService.findByPagesLess(pages);
			if (!book.equals(null)&&!book.isEmpty()) {

				response.setMessage("Book SuccessFully Find");
				response.setBody(book);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(book);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_book_price_range")
	public ResponseEntity<APIResponseDTO> findByPriceRange(@RequestHeader Integer start,@RequestHeader Integer end) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<BookEntity> book = bookService.findBookByPriceRange(start,end);
			if (!book.equals(null)&&!book.isEmpty()) {

				response.setMessage("Book SuccessFully Find");
				response.setBody(book);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(book);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_book_year")
	public ResponseEntity<APIResponseDTO> findByPriceRange(@RequestHeader Integer year) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<BookEntity> book = bookService.findBookByPublishYear(year);
			if (!book.equals(null)&&!book.isEmpty()) {

				response.setMessage("Book SuccessFully Find");
				response.setBody(book);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(book);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete_book_by_id")
	public ResponseEntity<APIResponseDTO> deleteBookById(@RequestHeader Integer id) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			String message = bookService.deleteBoookById(id);
			if (message.equals("Book Deleted Successfully")) {

				response.setMessage(message);
				response.setBody(null);
				response.setStatus(200);
			}
			else{
				response.setMessage(message);
				response.setBody(null);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To delete book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/update_book price")
	public ResponseEntity<APIResponseDTO> deleteBookById(@RequestHeader Integer id,@RequestHeader Integer price) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			String message = bookService.uodateBookprice(id,price);
			if (message.equals("Book price update Successfully")) {

				response.setMessage(message);
				response.setBody(null);
				response.setStatus(200);
			}
			else{
				response.setMessage(message);
				response.setBody(null);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To update price of book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}
}

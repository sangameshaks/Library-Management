package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookService {
	 String saveBook(Book book);

	   List<Book> getAllBook();

	   String deleteBook(int bookId);

	   String updateBook(Book book);

	   Book getBookById(int bookId);

	   String returnBook(Book bookId);
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookRent;
import com.example.demo.entity.LibraryUsers;

public interface BookRentService {
	 String rentBook(LibraryUsers userId, Book bookId);

	   List<BookRent> getAllBookRent();
}

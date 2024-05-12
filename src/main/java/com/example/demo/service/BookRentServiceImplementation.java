package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookRent;
import com.example.demo.entity.LibraryUsers;
import com.example.demo.repositoy.BookRentRepository;
import com.example.demo.repositoy.BookRepository;
import com.example.demo.repositoy.LibraryUsersRepository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class BookRentServiceImplementation implements BookRentService{
	 @Autowired
	   BookRentRepository Rent;
	   @Autowired
	   BookRepository b;
	   @Autowired
	   LibraryUsersRepository l;

	   public String rentBook(LibraryUsers userId, Book bookId) {
	      BookRent bookRent = new BookRent();
	      bookRent.setBookId(bookId);
	      System.out.println(bookId);
	      bookRent.setUserId(userId);
	      System.out.println(userId);
	      bookRent.setIssueDate(LocalDate.now());
	      LocalDate expdate = LocalDate.now();
	      LocalDate exp = expdate.plusDays(3L);
	      System.out.println(exp);
	      bookRent.setExpiryDate(exp);
	      this.Rent.save(bookRent);
	      return "BookRented Successfully";
	   }

	   public List<BookRent> getAllBookRent() {
	      return this.Rent.findAll();
	   }
}

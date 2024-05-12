package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repositoy.BookRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImplementation implements BookService {
	 @Autowired
	   BookRepository bookrepo;

	   public String saveBook(Book b) {
	      this.bookrepo.save(b);
	      return "book Added";
	   }

	   public List<Book> getAllBook() {
	      return this.bookrepo.findAll();
	   }

	   public String deleteBook(int bookId) {
	     // String message = "success";
	      Optional<Book> book = this.bookrepo.findById(bookId);
	      if (book.isPresent()) {
	         this.bookrepo.delete((Book)book.get());
	      }

	      return "book deleted";
	   }

	   public String updateBook(Book book) {
	      this.bookrepo.save(book);
	      return "Book updated succesfully";
	   }

	   public Book getBookById(int bookId) {
	      return (Book)bookrepo.findById(bookId).get();
	   }

	   public String returnBook(Book bookId) {
	      Book b = new Book();
	      b.setAvailableCopies(1);
	      b.setTotalNoOfCopies(1);
	      System.out.println("Book returned successfully");
	      bookrepo.save(b);
	      return "Book returned successfully";
	   }
}

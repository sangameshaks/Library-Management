package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.LibraryUsers;
import com.example.demo.repositoy.BookRepository;
import com.example.demo.repositoy.LibraryUsersRepository;
import com.example.demo.service.BookRentService;
import com.example.demo.service.BookService;
import com.example.demo.service.LibraryUsersService;
import com.example.demo.service.LibraryiansListService;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ServiceController {
	 BookRepository bookrepo;
	   LibraryUsersRepository lrepo;
	   @Autowired
	   LibraryUsersService lu;
	   @Autowired
	   BookService bs;
	   @Autowired
	   LibraryiansListService li;
	   @Autowired
	   BookRentService br;

	   @PostMapping({"/addLibraryUser"})
	   public String addUser(@RequestParam("userName") String userName, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("phoneNo") long phoneNo) {
	      boolean emailExists = lu.checkEmail(email);
	      if (!emailExists) {
	         LibraryUsers users = new LibraryUsers();
	         users.setUserName(userName);
	         users.setEmail(email);
	         users.setPassword(password);
	         users.setPhoneNo(phoneNo);
	         lu.addUser(users);
	         System.out.println("user registered successfully!");
	         return "LibraryUsers";
	      } else {
	         System.out.println("user already exists!");
	         return "LibraryUsers";
	      }
	   }

	   @PostMapping({"/RentBook"})
	   public String rentBook(@RequestParam("userId") LibraryUsers userId, @RequestParam("bookId") Book bookId) {
	      this.br.rentBook(userId, bookId);
	      System.out.println("Book rented Successfully");
	      return "BookRent";
	   }

	   @PostMapping({"/save"})
	   public String addbook(@ModelAttribute Book book) {
	      this.bs.saveBook(book);
	      return "BookList";
	   }

	   @PostMapping({"/UserFirstPage"})
	   public String validate(@RequestParam("email") String email, @RequestParam("password") String password) {
	      boolean val = this.lu.validate(email, password);
	      if (val) {
	         return "UserFirstPage";
	      } else {
	         System.out.println("incorrect credentials try again!");
	         return "UserLogin";
	      }
	   }

	   @PostMapping({"/FirstPage"})
	   public String validate(@RequestParam("name") String name, @RequestParam("password") int password) {
	      System.out.print(name);
	      System.out.print(password);
	      boolean val = this.li.validate1(name, password);
	      if (val) {
	         return "FirstPage";
	      } else {
	         System.out.println("incorrect credentials try again!");
	         return "LibraryianLogin";
	      }
	   }

	   @GetMapping({"/BookList"})
	   public ModelAndView getAllBook() {
	      List<Book> list = this.bs.getAllBook();
	      return new ModelAndView("BookList", "book", list);
	   }

	   @GetMapping({"/EiditBook"})
	   public String getUpdateBookPage(@PathVariable int id, Model model) {
	      Book book = this.bs.getBookById(id);
	      model.addAttribute("book", book);
	      return "EiditBook";
	   }

	   @GetMapping({"/DeleteBook"})
	   public ModelAndView getAllBookForDelete() {
	      List<Book> list = bs.getAllBook();
	      return new ModelAndView("DeleteBook", "book", list);
	   }

	   @GetMapping({"/DeleteUser"})
	   public ModelAndView getAllUserForDelete() {
	      List<LibraryUsers> list = lu.getAllUser();
	      return new ModelAndView("DeleteUser", "User", list);
	   }

	   @GetMapping({"/UpdateUser"})
	   public ModelAndView getAllUserForUpdate() {
	      List<LibraryUsers> list = lu.getAllUser();
	      return new ModelAndView("UpdateUser", "User", list);
	   }

	   @GetMapping({"/UpdateBook"})
	   public ModelAndView getAllBookForUpdate() {
	      List<Book> list = bs.getAllBook();
	      return new ModelAndView("UpdateBook", "book", list);
	   }

	   @PutMapping({"/{userId}"})
	   public ResponseEntity<List<LibraryUsers>> updateUser(@PathVariable int userId, @RequestBody LibraryUsers updatedUser) {
	      List<LibraryUsers> existingUser = lu.getAllUser();
	      if (existingUser == null) {
	         return ResponseEntity.notFound().build();
	      } else {
	         ((LibraryUsers)existingUser).setUserName(updatedUser.getUserName());
	         ((LibraryUsers)existingUser).setEmail(updatedUser.getEmail());
	         ((LibraryUsers)existingUser).setPassword(updatedUser.getPassword());
	         ((LibraryUsers)existingUser).setPhoneNo(updatedUser.getPhoneNo());
	         ((LibraryUsers)existingUser).setNoOfBookIssued(updatedUser.getNoOfBookIssued());
	         this.lu.addUser(updatedUser);
	         return ResponseEntity.ok(existingUser);
	      }
	   }

//	   @DeleteMapping({"/delete/{bookId}"})
//	   public ResponseEntity<String> deleteBook1(@PathVariable int bookId) {
//	      bs.deleteBook(bookId);
//	      return ResponseEntity.ok("Book with ID " + bookId + " deleted successfully");
//	   }
	   @DeleteMapping("/delete/{bookId}")
	    public ModelAndView deleteBook(@PathVariable int bookId) {
		   List<Book> list = bs.getAllBook();
	        // Use try-catch to handle exceptions gracefully
	        try {
	            bs.deleteBook(bookId);
	            return new ModelAndView("DeleteBook", "book", list);
	        } catch (Exception e) {
	            // Log the exception or handle it appropriately
	            return new ModelAndView("DeleteBook", "book", list);
	        }
	    }
	   
	   
	   
	   @DeleteMapping({"/delete1/{userId}"})
	   public ResponseEntity<String> deleteuser(@PathVariable int userId) {
	      lu.deleteUser(userId);
	      return ResponseEntity.ok("User with ID " + userId + " deleted successfully");
	   }

	   @RequestMapping({"/Update/{bookId}"})
	   public String updateBook(@PathVariable("bookId") int bookId, Model model) {
	      Book b = bs.getBookById(bookId);
	      model.addAttribute("book", b);
	      return "UpdateBook";
	   }

	   @PutMapping({"/UpdateBook/{bookId}"})
	   public String updateBook(@PathVariable("bookId") int bookId, @RequestBody Book updatedBook) {
	      Book existingBook = bs.getBookById(bookId);
	      if (existingBook != null) {
	         existingBook.setBookTitle(updatedBook.getBookTitle());
	         existingBook.setAuthor(updatedBook.getAuthor());
	        bs.updateBook(existingBook);
	         return "redirect:/update/" + bookId;
	      } else {
	         return "redirect:/books";
	      }
	   }

	   @RequestMapping({"/BookId/{bookId}"})
	   public ResponseEntity<String> getRentId(@PathVariable int bookId) {
	      return ResponseEntity.ok("Book id Not Found");
	   }

	   @PostMapping({"/ReturnBook"})
	   public void returnBook(@RequestParam("bookId") Book bookId) {
	      bs.returnBook(bookId);
	   }
	   
	   
	 
}

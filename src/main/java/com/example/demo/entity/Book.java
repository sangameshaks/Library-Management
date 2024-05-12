package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {
	 @Id
	   @GeneratedValue(
	      strategy = GenerationType.AUTO
	   )
	   int bookId;
	   String bookTitle;
	   String author;
	   int totalNoOfCopies = 1;
	   int availableCopies = 1;
}
